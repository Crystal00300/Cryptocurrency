package com.coin.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/about")
	public String gotoAbout() {
		return "about";
	}
	@GetMapping("/shellcoin/page2")
 	public String coinListPage2() {
		return "shellCoinPage2";
	}
	
	@GetMapping("/shellcoin/page3")
 	public String coinListPage3() {
		return "shellCoinPage3";
	}
	
	@GetMapping("/shellcoin/page4")
 	public String coinListPage4() {
		return "shellCoinPage4";
	}
	
	@GetMapping("/shellcoin/page5")
 	public String coinListPage5() {
		return "shellCoinPage5";
	}
	
	@GetMapping("/shellcoin/page6")
 	public String coinListPage6() {
		return "shellCoinPage6";
	}
	
	@GetMapping("/shellcoin/page7")
 	public String coinListPage7() {
		return "shellCoinPage7";
	}
	
	@GetMapping("/shellcoin/page8")
 	public String coinListPage8() {
		return "shellCoinPage8";
	}
	
	@GetMapping("/shellcoin/page9")
 	public String coinListPage9() {
		return "shellCoinPage9";
	}
	@GetMapping("/shellcoin/page10")
 	public String coinListPage10() {
		return "shellCoinPage10";
	}
}
