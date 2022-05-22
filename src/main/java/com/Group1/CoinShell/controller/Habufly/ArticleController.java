package com.Group1.CoinShell.controller.Habufly;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Group1.CoinShell.model.Habufly.Article;
import com.Group1.CoinShell.service.Habufly.ArticleService;
import com.Group1.CoinShell.service.Habufly.CommentService;


@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService aService;
	@Autowired
	private CommentService cService;
	
	@GetMapping("/article/add")  //	 ModelAndView 參數一定要放在第一個
	public ModelAndView goAddArticle(ModelAndView mav) {
		Article atc = new Article();
		
		//model.addAttribute("名字", 物件)
		mav.getModel().put("article", atc);
		
		mav.setViewName("addArticle");
		
		Article lastestArticle = aService.getFirstNewArticle();
		mav.getModel().put("lastestArticle", lastestArticle);
		
		return mav;
	}
	
	@PostMapping("/article/add")
	public ModelAndView postMessage(ModelAndView mav, @ModelAttribute(name="article") Article atc) {
		aService.save(atc);
		
		//save完之後，再帶入一個新的進去，否則格子內還是舊的
		Article newAtc = new Article();
		mav.getModel().put("article", newAtc);
		
		//回傳後顯示最新的那一筆留言
		Article lastestArticle = aService.getFirstNewArticle();
		mav.getModel().put("lastestArticle", lastestArticle);
		mav.setViewName("addArticle");
		return mav;
	}
	
	@GetMapping("/article/viewArticle")
	public String viewArticlePage(Model model, Article atc, @ModelAttribute("tag")String tag ,@RequestParam(name="p", defaultValue ="1") Integer pageNumber) {
		
		Page<Article> page = aService.findByPage(pageNumber);
		model.addAttribute("page",page);
		
		model.addAttribute("tag", atc.getTag());
		
		return "viewAll";
	}
	
	@ResponseBody//由於是寫在一般Controller底下，要將java物件序列化轉成Json格式，需寫
	@GetMapping("/article/viewAllAjax")
	public List<Article> viewArticlePage(@RequestParam String tag) {
		List<Article> allAtc;
		
		if("All".equals(tag)) {
			allAtc = aService.findAll();
		}else {
			allAtc = aService.findByTag(tag);
		}
		return allAtc;
	}
	//http://localhost:8080/myapp/article/viewAllAjax?tag=btc
	
	@ResponseBody
	@GetMapping("/article/viewAllAjaxByTitle")
	public List<Article> viewArticleByTitle(@RequestParam String titlePart) {
		List<Article> allAtc;
		
		allAtc = aService.findByTitle(titlePart);
		System.out.println(allAtc);
		return allAtc;
	}
	//http://localhost:8080/myapp/article/viewAllAjax?tag=btc
	
//	@ResponseBody
//	@GetMapping("/commentList")
//	public List<Comment> commentList(@RequestParam Integer aid) {
//		
//		
//		List<Comment> allComm = cService.selectComm(aid);
//		System.out.println(allComm);
//		return allComm;
//	}
	
//	@ResponseBody
//	@GetMapping("/replyList")
//	public List<Comment> replyList(@RequestParam Integer aid) {
//		List<Comment> allComm;
//		
//		allComm = cService.selectReply(aid);
//		System.out.println(allComm);
//		return allComm;
//	}
	
	@GetMapping("/editArticle/{id}")
	public String editArticle(Model model, @PathVariable("id")Integer id) {
		Article atc = aService.findById(id);
		model.addAttribute("article", atc);	
		return "editArticle";
	}
	
	@PostMapping("/postEditArticle")
	public String postEditArticle(Model model, @ModelAttribute("article")Article atc) {
		aService.save(atc);//save方法，有此id的話就會做update
		Integer id = atc.getId();
		System.out.println(id);
		model.addAttribute("id", id);
		return "redirect:/viewArticle/"+id+"/";
	}
	
	@GetMapping("/deleteArticle/{id}")
	public String deleteArticle(@PathVariable("id")Integer id) {
		Article atc = aService.findById(id);
		atc.setDeleted("y");
		aService.save(atc);
		return "redirect:/viewAllAjax";
	}
	//comment功能ajax改寫
	
	@ModelAttribute("tagList")
	public Map<String, String> getTags(){
		Map<String, String> tagList = new LinkedHashMap<String, String>();
		tagList.put("BTC", "比特幣");
		tagList.put("BCH", "比特幣現金");
		tagList.put("ETH", "以太幣");
		tagList.put("XRP", "瑞波幣");
		tagList.put("LTC", "萊特幣");
		tagList.put("EOS", "柚子幣");
		tagList.put("XLM", "恆星幣");
		tagList.put("ADA", "艾達幣");
		return tagList;
	}
	
//	@PostMapping("/viewArticle/{id}")
//	public void viewArticle2(HttpSession session, Model model, @PathVariable("id") Integer id,  @RequestParam(name="p", defaultValue ="1") Integer pageNumber) throws IOException{
//		//增加文章瀏覽數
//		aService.increasePageView(session, id);
//	}
	
	@GetMapping("/viewArticle/{id}")
    public String viewArticle(HttpSession session, Model model, @PathVariable("id") Integer id) throws IOException{
//		Page<Comment> page = cService.findByPage(pageNumber);
//		model.addAttribute("page",page);
		
//        List<Comment> commentsList;
//        List<Comment> replyList;
        
		Article atc = aService.findById(id);
		model.addAttribute("Article", atc);	
		
//		Comment comm = new Comment();
//		model.addAttribute("comment", comm);
//		
//		Comment reply = new Comment();
//		model.addAttribute("reply", reply);
		
        //增加文章瀏覽數
//		long lastAccessedTime = session.getLastAccessedTime();
//		long creationTime = session.getCreationTime();
//		System.out.println("lastAccessedTime:"+lastAccessedTime);
//		System.out.println("creationTime:"+creationTime);
//		System.out.println(lastAccessedTime-creationTime);
		aService.increasePageView(session, id);
		
//        synchronized (ArticleController.class) {
//            commentsList = cService.selectComm(id);  //查詢所有評論
//            replyList = cService.selectReply(id);  //查詢所有對評論的回復
//        }
//        model.addAttribute("commentsList", commentsList);
//        model.addAttribute("replyList", replyList);

        return "viewArticle";
    }
	
//	@GetMapping("/article/viewArticleByTag")
//	public String viewArticlePageByTag(Model model, @RequestParam("tag")String rTag ,@RequestParam(name="p", defaultValue ="1") Integer pageNumber) {
//		
//		System.out.println("#########################################"+rTag);
//		Page<Article> page = aService.findByPageAndTag(pageNumber, rTag);
//		model.addAttribute("page",page);
//		
//		return "viewAll";
//	}
	
}
