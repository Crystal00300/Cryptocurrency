package com.coin.springbootdemo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coin.springbootdemo.model.Coin;
import com.coin.springbootdemo.model.CoinDao;

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

}
