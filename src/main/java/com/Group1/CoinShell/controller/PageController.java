package com.Group1.CoinShell.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.CoinShell.model.Hoxton.Cryptocurrency;
import com.Group1.CoinShell.service.Hoxton.CryptocurrencyInformationService;

@Controller

public class PageController {
	
	@Autowired
	CryptocurrencyInformationService service;
	
	@GetMapping(name="/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		return "/test";
	}
	

	

	

}
