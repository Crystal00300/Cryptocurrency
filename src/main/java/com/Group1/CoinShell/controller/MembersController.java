//package com.Group1.CoinShell.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.Group1.CoinShell.model.Members;
//import com.Group1.CoinShell.service.MembersService;
//
//@Controller
//public class MembersController {
//	
//	@Autowired
//	private MembersService membersService;
//	
///* 不是導向至登入「頁面」，因此先註解之 */
////	@GetMapping("/memberlogin")
////	public String memberLoginModal() {
////		return "login";
////	}
//	
//	// RedirectAttributes : redirect 帶值跳頁
//	@PostMapping("/loginPost")
//	public String postForm(@RequestParam("email") String eMail, 
//					       @RequestParam("password") String password, 
//					       HttpSession httpSession, 
//					       RedirectAttributes redirectAttributes) {
//		
//		Members result = membersService.checkLogin(eMail, password);
//		
//		if (result == null) {
//			redirectAttributes.addFlashAttribute("loginError", "帳號密碼錯誤，請重新輸入");
//			return "redirect:memberslogin";
//		}
//		httpSession.setAttribute("loginMembers", result);
//		
//		return "loginOK";
//	}
//
//}
