package com.Group1.CoinShell.controller.Yiwen;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Group1.CoinShell.model.Yiwen.Members;
import com.Group1.CoinShell.model.Yiwen.MembersDao;
import com.Group1.CoinShell.service.Yiwen.MembersService;

@Controller
public class MembersController {
	
	@Autowired
	MembersService memService;
	
	@Autowired
	MembersDao dao;
	
	@GetMapping("/signup")
	public String signupPage(Model model) {
		model.addAttribute("memberBean", new Members());
		return "signup";
	}
	
//	@PostMapping("/signup")
//	public String postSignUp(@ModelAttribute("memberBean") Members members) {
//		SimpleDateFormat sdf = new SimpleDateFormat();123
//		Date date = new Date();
//		// TODO: 之後要寫沒有填 email /pwd 註冊失敗的條件式
//		sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
//		members.setCustomizedUserName("defaultUser");
//		members.setCustomizedUserAvatar("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAUIAAADmCAIAAAAvNRuHAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAFiUAABYlAUlSJPAAAADuSURBVHhe7cExAQAAAMKg9U/tawggAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA4NWT3AAHCzkfXAAAAAElFTkSuQmCC");
//		members.setMyShell(0);
//		members.setJoinTime(date);
//		Members resMem = dao.save(members);
//		memService.insert(resMem);
//		memService.save(members);
//		return "signupOK";
//	}
	
	@PostMapping("/signup")
	public String signUp(@RequestParam("e-mail")String eMail ,@RequestParam("password") String password) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date date = new Date();
		Members member = new Members();
		member.setCustomizedUserAvatar("data:image/png;base64,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");
		member.setMyShell(0);
		member.seteMail(eMail);
		member.setJoinTime(date);
		member.setPassword(password);
		member.setCustomizedUserName("New User");
		// if (DAO.findMemberByEMail()){
		// return "/index";
		// }else{
		memService.save(member);
		return "signupOK";
	}
	
	@GetMapping("/account/set")
	public String getAccountSet(Model model) {
		model.addAttribute("memberBean", new Members());
		return "/account/set";
	}
	
	@GetMapping("/account/referral")
	public String getReferral(Model model) {
		model.addAttribute("memberBean", new Members());
		return "/account/referral";
	}
	
	@GetMapping("/aboutUs/intro")
	public String getIntro() {
		return "aboutUs/intro";
	}
	
	@GetMapping("/account/privacy")
	public String getPrivacy() {
		return "account/privacy";
	}
	
	@GetMapping("/account/cookie")
	public String getCookie() {
		return "account/cookie";
	}
	

	@GetMapping("/login")
	public String getloginPage(Model model) {
		model.addAttribute("memberBean", new Members());
		return "login";
	}

	
	@PostMapping("/login")
	public String postLogin(@RequestParam("eMail") String eMail, 
			HttpSession httpSession, RedirectAttributes redirectAttributes) {
		Members memRes = dao.findMemberByEMail(eMail);
		
		if(memRes == null) {
			redirectAttributes.addFlashAttribute("loginError", "帳號密碼錯誤，請重新輸入");
			return "redirect:/";
		}
		httpSession.setAttribute("login", memRes);
		return "index";
	}
	
	
//	public String updateAvatar() {
//		
//		return null;
//	}
	
	@GetMapping("/logout")
	public String LogOut(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		request.getSession().invalidate();
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("JSESSIONID")) {
				c.setMaxAge(0);
				break;
			}
		}
		return "redirect:/";
		
	}
	
		
//		Members resMem = memService.findMemberByEMail(members.geteMail());
//		if(resMem.getPassword().equals(members.getPassword())){
//			System.out.println("登入成功");
//		}else {
//			System.out.println("登入失敗");
//		}


	
//	public String postSignUp(@ModelAttribute("memberBean") Members members) {
//		
//	}
	
//	@GetMapping("/signup")
//	public String signupPage() {
//		return "signup";
//	}
	
//	@PostMapping("/signup")
//	public String postForm(@ModelAttribute("memberBean") Members members) {
//		System.out.println(members.geteMail());
//		System.out.println(123);
//		return "loginOK";
//	}
	

}

