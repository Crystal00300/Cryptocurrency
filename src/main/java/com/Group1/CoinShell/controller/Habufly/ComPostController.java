package com.Group1.CoinShell.controller.Habufly;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Group1.CoinShell.model.Habufly.Comment;
import com.Group1.CoinShell.service.Habufly.ArticleService;
import com.Group1.CoinShell.service.Habufly.CommentService;



@Controller
public class ComPostController {
    @Autowired
    private CommentService cService;
    @Autowired
    private ArticleService aService;

    @ResponseBody
    @GetMapping("/viewComment")
    public List<Comment> viewComment(@RequestParam Integer articleId) throws IOException{
    	List<Comment> allComm = cService.selectComm(articleId);
    	return allComm;
    }
    
    @ResponseBody
    @GetMapping("/viewReply")
    public List<Comment> viewReply(@RequestParam Integer articleId, @RequestParam Integer commentId) throws IOException{
    	List<Comment> allReply = cService.selectReply(articleId, commentId);
    	return allReply;
    }
    
    @ResponseBody
    @PostMapping("/editComment")
    public List<Comment> editComment(@RequestBody Comment comm) throws IOException{
		
    	Integer articleId = comm.getArticleId();
		List<Comment> oldComm = cService.selectComm(articleId);
		System.out.println(oldComm);
		
    	if (comm.getText().equals("") || comm.getUserEmail().equals("") || comm.getUserName().equals("")) {
    		return oldComm;
        }
        //判斷Email的正則表達
        String checkemail = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(checkemail);
        Matcher matcher = regex.matcher(comm.getUserEmail());
        if (matcher.matches()==false){
        	return oldComm;
        }
        //設定同時只能執行一個              
        synchronized (ComPostController.class){
        cService.inserComm(comm);
        }
        //取得該Article的評論數並更新
        Integer commentNum = cService.checkCommentNum(articleId, "a");
        aService.updatCommentNum(articleId, commentNum);
        
        List<Comment> allComm = cService.selectComm(articleId);
        return allComm;
    }
    
    @ResponseBody
    @PostMapping("/editReply")
    public List<Comment> editReply(@RequestBody Comment comm, @RequestParam Integer commentId) throws IOException{
    	
    	Integer articleId = comm.getArticleId();
    	List<Comment> oldReply = cService.selectReply(articleId, commentId);
    	System.out.println(oldReply);
    	
    	if (comm.getText().equals("") || comm.getUserEmail().equals("") || comm.getUserName().equals("")) {
    		return oldReply;
    	}
    	//判斷Email的正則表達
    	String checkemail = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    	Pattern regex = Pattern.compile(checkemail);
    	Matcher matcher = regex.matcher(comm.getUserEmail());
    	if (matcher.matches()==false){
    		return oldReply;
    	}
    	//設定同時只能執行一個              
    	synchronized (ComPostController.class){
    		cService.inserComm(comm);
    	}
    	
    	List<Comment> allReply = cService.selectReply(articleId, commentId);
    	return allReply;
    }

//    @PostMapping("/editReply")
//    public void editReply(HttpServletResponse respone, @ModelAttribute(name = "reply") Comment comm, @PathParam("articleId") Integer articleId, @RequestParam("text") String text, @RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail) throws IOException {
//    	if (text.equals("") || userEmail.equals("") || userName.equals("")) {
//    		respone.sendRedirect("viewArticle/"+articleId);
//    		return;
//        }
//    	synchronized (ComPostController.class){
//            cService.inserComm(comm);
//            }
//    		respone.sendRedirect("viewArticle/"+articleId);
//    }

//    @RequestMapping(value = "/manage/deletecomment", method = RequestMethod.POST)
//    public @ResponseBody String setArticle(@RequestParam int id,@RequestParam int page,HttpServletRequest request)throws IOException{
////        String Iid = request.getParameter("delete");
////        int IDid = Integer.parseInt(id);
////        System.out.println("delete: "+Iid);
//        commentService.deleteReply(id);          //先刪除所有對評論的回覆
//        commentService.deleteCom(id);			//刪除評論
//        return "success";
//    }
//
}
