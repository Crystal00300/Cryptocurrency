package com.Group1.CoinShell.controller.Feeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.CoinShell.model.Feeder.CoinDao;
import com.Group1.CoinShell.service.Feeder.CoinService;

@Component // 在 SpringbootdemoApplication 注入@EnableScheduling 搭配下面@Scheduled 以啟動定時器排程
@RestController
public class CoinCointroller {

	@Autowired
	private CoinService coinService;

	@Autowired
	private CoinDao coinDao;
	                                                    // 需搭配@Component
	
}
