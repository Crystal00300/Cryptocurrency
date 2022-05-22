package com.Group1.CoinShell.controller.Hoxton;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.CoinShell.model.Hoxton.CryptocurryencyDao;

@RestController
public class CryptocurrencyControllerApi {
	@Autowired
	private CryptocurryencyDao dao;
	
	@GetMapping("historical/get")
	public List<Map<String, Object>> findHistoricalCurrencyInformation(@RequestParam String currencyName,
			@RequestParam String day) {
		List<Map<String, Object>> findHistoricalCurrencyInformation = dao
				.findHistoricalCurrencyInformation(currencyName, day);
		return findHistoricalCurrencyInformation;
	}
	
	@GetMapping("/historical/get30days")
	public List<Map<String,Object>> find30DaysCurrencyInformation(@RequestParam("currencyName") String currencyName) {
		List<Map<String,Object>> find30DaysCurrencyInformation = dao.find30DaysCurrencyInformation(currencyName);
		return find30DaysCurrencyInformation;
	}
	// http://localhost:8080/coinshell/historical/get30days?currencyName=btc
	

	@GetMapping("/historical/get30daysInformationday")
	public List<String> findLastestCurrencyInformationdDay(@RequestParam("currencyName") String currencyName) {
		List<String> get30DaysCurrencyInformationDate = dao.find30DaysCurrencyInformationDate(currencyName);
		return get30DaysCurrencyInformationDate;
	}
	//http://localhost:8080/coinshell/historical/get30daysInformationday?currencyName=btc
	
	@GetMapping("/historical/get30daysUsdPrice")
	public List<String> find30DaysCurrencyUsdPrice(@RequestParam("currencyName") String currencyName) {
		List<String> get30DaysCurrencyUsdPrice = dao.find30DaysCurrencyUsdPrice(currencyName);
		return get30DaysCurrencyUsdPrice;
	}
	//http://localhost:8080/coinshell/historical/get30daysUsdPrice?currencyName=btc
}
