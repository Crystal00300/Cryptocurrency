package com.Group1.CoinShell.controller.Hoxton;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.CoinShell.model.Hoxton.News;
import com.Group1.CoinShell.model.Hoxton.NewsDao;

@Controller
public class NewsController {
	
	@Autowired
	private NewsDao dao;
	
	@PostMapping("news/insert")
	@ResponseBody
	public News insertNews() {
		News news = new News();
//		LocalDateTime localDateTime  = LocalDateTime.now();
//		Date date = (Date) Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
//		news.setDate(date);
		news.setTitle("標題");
		news.setImageOfNews("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQEAYABgAAD/2wBDAAIBAQIBAQICAgICAgICAwUDAwMDAwYEBAMFBwYHBwcGBwcICQsJCAgKCAcHCg0KCgsMDAwMBwkODw0MDgsMDAz/2wBDAQICAgMDAwYDAwYMCAcIDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAz/wAARCABJAFwDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD+f+iiigAooooAKKKKACiiigAooooAKKKKACiiigAoor0T9ln9mnXf2ufjLa+B/Dd3pNlq13p+o6kkupSyR24jsbGe+lBaNHbcYrdwvy4LFQSoJYHRy6JNv0Su38kgPO6KKKACivRPA/7NOu+P/wBnDx98ULO70mPQPh1qGk6bqVvNLILyeTUTciAwqEKMq/ZZN+51I3LgNk487oeknF7q34pNfg0/mAUUUUAFFFFABRRRQAV9q/8ABAv4ueLPhr/wUFsrPwz4m8Q6BFr3hfxLHdwaZqM1quovFoOozWyyLGw8wpOsbxg52yKrLhgDXxVWr4H8da38MfF+neIPDesar4e1/R51urDUtMu5LS8sZlOVkiljIdHB6MpBFNP3ZR25oyjftzRcb/K9xP0v/wAA/Rj9mr45J4a/4JqeIfjJqPxp+OHgz4peK/iU+jeNvH3hDSF8R+J5LRbCCXT7S5vZ9VsZ7W3mdbl8pI4uHtlV+IUFbaft7fDyy/aV+J2o+HtO+Pnwht/jHaeGLZ/ir4X8PwaF4m0bWfsHmTO1jb3DLJY6rMUvpbeC9ikl2LIDLtUH4G8K/ttfGfwJ8Udc8caJ8XPido3jTxMgj1jxBY+Kb631TVlG0hbi5SUSyj5E4dj91fQVH8P/ANtD4xfCbxx4i8TeFvix8S/DXiTxfKZ9e1bSvE97Z32tyF2cvdTRyq87F3dsyFjliepNUprn5mtLR0Tta0YxaT3SfLzXXLZ2upW1nlag4p63er63k5Xa2utI630uk430++dS+JXxr/Y9/Y6/bm8A/wDC3vEp1nwJ8SfD9lNdeGNZuNOsQ11dasmoSQQQtGtulw4iE0aqoLKqODtAr8u67H4UftD+P/gNqOq3ngbxz4w8GXeu2rWOpT6FrNzp0mo27HLQzNC6mSMkAlWyCe1cdXPTpuLvJ3doLa3wwUNl092/k21bS73qzUpPl0V2183f7/8ALcKKKK1MwooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA//2Q==");
		news.setContentOfNews("內容");
		news.setRelevant_Currency1("BTC");
//		news.setRelevant_Currency2("ETH");
		dao.save(news);
		return news;
	}
	
	@GetMapping("news/get")
	@ResponseBody
	public List<News> findAllNewsByCurrencyName(@RequestParam String currencyName){
		List<News> newsList = dao.findAllNewsByCurrencyName(currencyName);
		return newsList;
	}
//http://localhost:8080/coinshell/news/get?currencyName=BTC
	
	
}
