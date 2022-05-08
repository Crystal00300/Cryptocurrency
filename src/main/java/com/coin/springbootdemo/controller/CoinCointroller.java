package com.coin.springbootdemo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coin.springbootdemo.model.Coin;
import com.coin.springbootdemo.model.CoinDao;
import com.coin.springbootdemo.service.CoinService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component // 在 SpringbootdemoApplication 注入@EnableScheduling 搭配下面@Scheduled 以啟動定時器排程
@RestController
public class CoinCointroller {

	@Autowired
	private CoinService coinService;

	@Autowired
	private CoinDao coinDao;
	                                                    // 需搭配@Component
	@Scheduled(initialDelay = 2000, fixedRate = 30000)  // 定時器 啟動專案 initialDelay 毫秒 後啟動 每 fixedRate 毫秒 RUN一次
	@PostMapping("coin/insert")
	public void updateCoin() throws JsonProcessingException {
		// 測試定時器有沒有動 顯示當前時間
		System.out.println(LocalDateTime.now());

		// 取得網頁內容並生成JAVA字串物件 網址內容本身就是JSON字串 故不用再轉JSON格式
		String strUrl    = "https://api.coinmarketcap.com/data-api/v3/cryptocurrency/listing?start=1&limit=100&sortBy=market_cap&sortType=desc&convert=USD&cryptoType=all&tagType=all&audited=false";
		String coinstr   = coinService.getContent(strUrl);

		
		//產生 [{"id":1,"coid":1.....}] 的JSON字串 (用字串切割器把 標頭 及 尾段 多餘字串去掉) 以便 轉成JSONArray
		String coinstr1  = coinstr.substring(coinstr.indexOf("["), coinstr.lastIndexOf("]") + 1); // +1 為切到 " ] " 後面一個字元 ( 目的為保留 " ] ")

		
		//切好的字串 產生JSONArray
		JSONArray jArray = new JSONArray(coinstr1);

		if (jArray != null) {
			for (Object obj : jArray) {
				JSONObject jo = (JSONObject) obj;

				Integer coid    = jo.getInt("id");
				String  name    = jo.getString("name");
				String  symbol  = jo.getString("symbol");
				String  slug    = jo.getString("slug");
//				String  tags    = jo.getJSONArray("tags").toString();  //list 目前不會寫
				Integer cmcRank = jo.getInt("cmcRank");
				Integer marketPairCount   = jo.getInt("marketPairCount");
				Double  circulatingSupply = jo.getDouble("circulatingSupply");
				Integer selfRCSupply      = jo.getInt("selfReportedCirculatingSupply");
				Double  totalSupply       = jo.getDouble("totalSupply");
				
				//如果 沒有 "maxSupply" 這個key 則補 key : value 為  "maxSupply" : 0.0
				if(!jo.has("maxSupply")) {
					jo.put("maxSupply", 0.0);
				}
				
				Double  maxSupply        = jo.getDouble("maxSupply");
				Integer isActive         = jo.getInt("isActive");
				String  lastUpdated      = jo.getString("lastUpdated");
				String  dateAdded        = jo.getString("dateAdded");
				String  quotesName       = jo.getJSONArray("quotes").getJSONObject(0).getString("name"); //找到quotes下的第1層[]裡面的key
				Double  price            = jo.getJSONArray("quotes").getJSONObject(0).getDouble("price");
				Double  volume24h        = jo.getJSONArray("quotes").getJSONObject(0).getDouble("volume24h");
				Double  marketCap        = jo.getJSONArray("quotes").getJSONObject(0).getDouble("marketCap");
				Double  percentChange1h  = jo.getJSONArray("quotes").getJSONObject(0).getDouble("percentChange1h");
				Double  percentChange24h = jo.getJSONArray("quotes").getJSONObject(0).getDouble("percentChange24h");
				Double  percentChange7d  = jo.getJSONArray("quotes").getJSONObject(0).getDouble("percentChange7d");
				Double  percentChange30d = jo.getJSONArray("quotes").getJSONObject(0).getDouble("percentChange30d");
				Double  percentChange60d = jo.getJSONArray("quotes").getJSONObject(0).getDouble("percentChange60d");
				Double  percentChange90d = jo.getJSONArray("quotes").getJSONObject(0).getDouble("percentChange90d");
				Double  fullyDilluttedMarketCap  = jo.getJSONArray("quotes").getJSONObject(0).getDouble("fullyDilluttedMarketCap");
				Double  marketCapByTotalSupply   = jo.getJSONArray("quotes").getJSONObject(0).getDouble("marketCapByTotalSupply");
				Double  ytdPriceChangePercentage = jo.getJSONArray("quotes").getJSONObject(0).getDouble("ytdPriceChangePercentage");
				Double  dominance   = jo.getJSONArray("quotes").getJSONObject(0).getDouble("dominance");
				Double  turnover    = jo.getJSONArray("quotes").getJSONObject(0).getDouble("turnover");
				boolean isAudited   = jo.getBoolean("isAudited");
//				String  auditor     = jo.getJSONArray("auditInfoList").getJSONObject(0).getString("turnover");      //這個KEY有些幣沒有 寫了會報錯
//				Integer auditStatus = jo.getJSONArray("auditInfoList").getJSONObject(0).getInteger("auditStatus");  //這個KEY有些幣沒有 寫了會報錯
//				String  reportUrl   = jo.getJSONArray("auditInfoList").getJSONObject(0).getString("reportUrl");     //這個KEY有些幣沒有 寫了會報錯
				

				Coin coin = new Coin();
				
				coin.setId(cmcRank); // 依照排名順序給ID的順序 因為要做更新 所以ID不能一直增加 故用cmcRank值只有1到100 (save方法:已經有id的值會自動變更新)
				coin.setCoid(coid);  // 承上 也可以直接用cmcRank當作主key (在beans頁面的cmcRank上注入@id) 但我想要有id 所以用上面的方法
				coin.setName(name);
				coin.setSymbol(symbol);
				coin.setSlug(slug);
//				coin.setTags(tags);
				coin.setCmcRank(cmcRank);
				coin.setMarketPairCount(marketPairCount);
				coin.setCirculatingSupply(circulatingSupply);
				coin.setSelfReportedCirculatingSupply(selfRCSupply);
				coin.setTotalSupply(totalSupply);
				coin.setMaxSupply(maxSupply);
				coin.setIsActive(isActive);
				coin.setLastUpdated(lastUpdated);
				coin.setDateAdded(dateAdded);
				coin.setQuotesName(quotesName);
				coin.setPrice(price);
				coin.setVolume24h(volume24h);
				coin.setMarketCap(marketCap);
				coin.setPercentChange1h(percentChange1h);
				coin.setPercentChange24h(percentChange24h);
				coin.setPercentChange7d(percentChange7d);
				coin.setPercentChange30d(percentChange30d);
				coin.setPercentChange60d(percentChange60d);
				coin.setPercentChange90d(percentChange90d);
				coin.setFullyDilluttedMarketCap(fullyDilluttedMarketCap);
				coin.setMarketCapByTotalSupply(marketCapByTotalSupply);
				coin.setDominance(dominance);
				coin.setTurnover(turnover);
				coin.setYtdPriceChangePercentage(ytdPriceChangePercentage);
				coin.setAudited(isAudited);
//				coin.setAuditor(auditor);
//				coin.setAuditStatus(auditStatus);
//				coin.setReportUrl(reportUrl);

				Coin upCoin = coinDao.save(coin);
			}
		}

	}

	//定時從資料庫抓資料 到 路徑網址 預設/coin/getAll (已經在JSP AJAX設定輪詢 這邊就不用在訂時跟資料庫要資料了)
	//@Scheduled(initialDelay = 3000, fixedRate = 20000)
	@GetMapping("coin/getAll")
	public List<Coin> findAllcoin() {
		List<Coin> allCoinList = coinDao.findAll();
		return allCoinList;

	}
	
	//已經在JSP AJAX設定輪詢 這邊就不用在訂時跟資料庫要資料了
	@GetMapping("coin/page/{pageNumber}")
	public List<Coin> findByPage(@PathVariable Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "id");

		Page<Coin> page = coinDao.findAll(pgb);

		List<Coin> list = page.getContent();

		return list;
	}

}
