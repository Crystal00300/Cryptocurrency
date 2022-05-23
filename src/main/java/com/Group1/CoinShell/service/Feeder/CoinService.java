package com.Group1.CoinShell.service.Feeder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.CoinShell.model.Feeder.Coin;
import com.Group1.CoinShell.model.Feeder.CoinDao;

@Service
@Transactional
public class CoinService {

	@Autowired
	private CoinDao coindao;

	public void save(Coin coin) {
		coindao.save(coin);
	}

	public void saveAll(List<Coin> coin) {
		coindao.saveAll(coin);
	}
	
	public List<Coin> findAll(Coin coin) {
		return coindao.findAll();
	}

	public List<Coin> findByName(String name) {
		return coindao.findByName(name);
	}

	
	public Coin findById(Integer id) {
		Optional<Coin> option = coindao.findById(id);

		if (option.isPresent()) {
			return option.get();
		}
		return null;
	}
	
	public Coin getCoinById(Integer id) {
		return coindao.findById(id).get();
	}


	public String getContent(String strUrl) {
		// 一個public方法,返回字串,錯誤則返回"error open url"
		try {
			URL url = new URL(strUrl);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String s = "";
			StringBuffer sb = new StringBuffer("");
			while ((s = br.readLine()) != null) {
				sb.append(s + "/r/n");
			}
			br.close();
			return sb.toString();

		} catch (Exception e) {
			return "error open url: " + strUrl;
		}
	}

	public Coin findLastestCurrencyInformation(String currencyName) {
		Coin findLastestCurrencyInformation = coindao.findLastestCurrencyInformation(currencyName);
		return findLastestCurrencyInformation;
	}

}
