package com.Group1.CoinShell.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Group1.CoinShell.model.Cryptocurrency;
import com.Group1.CoinShell.model.CryptocurryencyDao;

@Controller
public class CryptocurrencyController {

	@Autowired
	private CryptocurryencyDao dao;

	@GetMapping("historical/get")
	@ResponseBody
	public List<Map<String, Object>> findHistoricalCurrencyInformation(@RequestParam String currencyName,
			@RequestParam String day) {
		List<Map<String, Object>> findHistoricalCurrencyInformation = dao
				.findHistoricalCurrencyInformation(currencyName, day);
		return findHistoricalCurrencyInformation;
	}

	@GetMapping("/individualCryptocurrencyInformation")
	public String getCryptocurrency(@RequestParam("currencyName") String name, @RequestParam("currentlyDay") String day,
			Model model) {
		Cryptocurrency lastestCurrencyInformation = dao.findLastestCurrencyInformation(name);
		dao.findHistoricalCurrencyInformation(name, day);
		model.addAttribute("currencyInformation", lastestCurrencyInformation);
		System.out.println(lastestCurrencyInformation);
		return "individualCryptocurrencyInformation";
	}

	@ResponseBody
	@GetMapping("/historical/get30days")
	public List<Map<String,Object>> find30DaysCurrencyInformation(@RequestParam("currencyName") String currencyName) {
		List<Map<String,Object>> find30DaysCurrencyInformation = dao.find30DaysCurrencyInformation(currencyName);
		return find30DaysCurrencyInformation;
	}
	// http://localhost:8080/coinshell/historical/get30days?currencyName=btc
	
	@ResponseBody
	@GetMapping("/historical/get30daysInformationday")
	public List<String> findLastestCurrencyInformationdDay(@RequestParam("currencyName") String currencyName) {
		List<String> get30DaysCurrencyInformationDate = dao.find30DaysCurrencyInformationDate(currencyName);
		return get30DaysCurrencyInformationDate;
	}
	//http://localhost:8080/coinshell/historical/get30daysInformationday?currencyName=btc
	
	
	@ResponseBody
	@GetMapping("/historical/get30daysUsdPrice")
	public List<String> find30DaysCurrencyUsdPrice(@RequestParam("currencyName") String currencyName) {
		List<String> get30DaysCurrencyUsdPrice = dao.find30DaysCurrencyUsdPrice(currencyName);
		return get30DaysCurrencyUsdPrice;
	}
	//http://localhost:8080/coinshell/historical/get30daysUsdPrice?currencyName=btc
	
	

}
