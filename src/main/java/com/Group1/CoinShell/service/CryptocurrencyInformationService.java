package com.Group1.CoinShell.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.CoinShell.model.Cryptocurrency;
import com.Group1.CoinShell.model.CryptocurryencyDao;

@Service
@Transactional
public class CryptocurrencyInformationService {

	@Autowired
	private CryptocurryencyDao dao;


	public Cryptocurrency findLastestCurrencyInformation(String currencyName) {
		return dao.findLastestCurrencyInformation(currencyName);
	}
	
	public List<Map<String,Object>> findHistoricalCurrencyInformation(String currencyName,String date) {
		return dao.findHistoricalCurrencyInformation(currencyName, date);
	}
	
	public List<Map<String,Object>> find30DaysCurrencyInformation(String currencyName) {
		return dao.find30DaysCurrencyInformation(currencyName);
	}

}
