package com.coin.springbootdemo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONArray;
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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component // 在 SpringbootdemoApplication 注入@EnableScheduling 搭配下面@Scheduled 以啟動定時器排程
@RestController
public class CoinCointroller {

	@Autowired
	private CoinService coinService;

	@Autowired
	private CoinDao coinDao;

	@Scheduled(initialDelay = 2000, fixedRate = 10000) // 定時器 啟動專案 initialDelay 毫秒 後啟動 每 fixedRate 毫秒 RUN一次 需搭配@Component
	@PostMapping("coin/insert")
	public void updateCoin() throws JsonProcessingException {
		// 測試定時器有沒有動 顯示當前時間
		System.out.println(LocalDateTime.now());

		// 取得網頁內容並生成JAVA字串物件 網址內容本身就是JSON串 故不用再轉JSON
		String strUrl  = "https://api.coinmarketcap.com/data-api/v3/cryptocurrency/listing?start=1&limit=100&sortBy=market_cap&sortType=desc&convert=USD&cryptoType=all&tagType=all&audited=false";
		String coinstr = coinService.getContent(strUrl);

		ObjectMapper mapper = new ObjectMapper();

		JsonNode  node = mapper.readTree(coinstr);
		String    cryptoCurrencyList = node.get("data").get("cryptoCurrencyList").toString();

		JsonNode  node2  = mapper.readTree(cryptoCurrencyList);
		JSONArray jArray = new JSONArray(node2);
		
		for (int i = 0; i < jArray.length(); i++) {
			
			Integer coid    = node2.get(i).get("id").asInt();
			String  name    = node2.get(i).get("name").asText();
			String  symbol  = node2.get(i).get("symbol").asText();
			String  slug    = node2.get(i).get("slug").asText();
//			String[]tags    = node2.get(i).get("tags").asText(); //陣列 不會寫
			Integer cmcRank = node2.get(i).get("cmcRank").asInt();
			Integer marketPairCount   = node2.get(i).get("marketPairCount").asInt();
			Double  circulatingSupply = node2.get(i).get("circulatingSupply").asDouble();
			Integer selfReportedCirculatingSupply = node2.get(i).get("selfReportedCirculatingSupply").asInt();
			Double  totalSupply = node2.get(i).get("totalSupply").asDouble();
//			Double  maxSupply   = null;//node2.get(i).get("maxSupply").asDouble(); // 這個KEY有些幣沒有 寫了會報錯
			Integer isActive    = node2.get(i).get("isActive").asInt();
			String  lastUpdated = node2.get(i).get("lastUpdated").asText(); // DATE不會寫 先用String
			String  dateAdded   = node2.get(i).get("dateAdded").asText();   // DATE不會寫 先用String
			String  quotesName = node2.get(i).get("quotes").get(0).get("name").asText();
			Double  price       = node2.get(i).get("quotes").get(0).get("price").asDouble();
			Double  volume24h   = node2.get(i).get("quotes").get(0).get("volume24h").asDouble();
			Double  marketCap   = node2.get(i).get("quotes").get(0).get("marketCap").asDouble();
			Double  percentChange1h  = node2.get(i).get("quotes").get(0).get("percentChange1h").asDouble();
			Double  percentChange24h = node2.get(i).get("quotes").get(0).get("percentChange24h").asDouble();
			Double  percentChange7d  = node2.get(i).get("quotes").get(0).get("percentChange7d").asDouble();
			Double  percentChange30d = node2.get(i).get("quotes").get(0).get("percentChange30d").asDouble();
			Double  percentChange60d = node2.get(i).get("quotes").get(0).get("percentChange60d").asDouble();
			Double  percentChange90d = node2.get(i).get("quotes").get(0).get("percentChange90d").asDouble();
			Double  fullyDilluttedMarketCap  = node2.get(i).get("quotes").get(0).get("fullyDilluttedMarketCap").asDouble();
			Double  marketCapByTotalSupply   = node2.get(i).get("quotes").get(0).get("marketCapByTotalSupply").asDouble();
			Double  dominance   = node2.get(i).get("quotes").get(0).get("dominance").asDouble();
			Double  turnover    = node2.get(i).get("quotes").get(0).get("turnover").asDouble();
			Double  ytdPriceChangePercentage = node2.get(i).get("quotes").get(0).get("ytdPriceChangePercentage").asDouble();
			boolean isAudited   = node2.get(i).get("isAudited").asBoolean();
//			String  auditor     = node2.get(i).get("auditInfoList").get(0).get("auditor").asText();     //這個KEY有些幣沒有 寫了會報錯
//			Integer auditStatus = node2.get(i).get("auditInfoList").get(0).get("auditStatus").asInt();  //這個KEY有些幣沒有 寫了會報錯
//			String  reportUrl   = node2.get(i).get("auditInfoList").get(0).get("reportUrl").asText();   //這個KEY有些幣沒有 寫了會報錯

			
			Coin coin = new Coin();
			
			coin.setId(cmcRank); // 依照排名順序給ID的順序 因為要做更新 所以ID不能一直增加 故用cmcRank值只有1到100 (save方法:已經有id的值會自動變更新)
			coin.setCoid(coid);  // 承上 也可以直接用cmcRank當作主key (在beans頁面的cmcRank上注入@id) 但我想要有id 所以用上面的方法
			coin.setName(name);
			coin.setSymbol(symbol);
			coin.setSlug(slug);
//			coin.setTags(tags);
			coin.setCmcRank(cmcRank);
			coin.setMarketPairCount(marketPairCount);
			coin.setCirculatingSupply(circulatingSupply);
			coin.setSelfReportedCirculatingSupply(selfReportedCirculatingSupply);
			coin.setTotalSupply(totalSupply);
//			coin.setMaxSupply(maxSupply);
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
			coin.setMaxSupply(marketCapByTotalSupply);
			coin.setDominance(dominance);
			coin.setTurnover(turnover);
			coin.setYtdPriceChangePercentage(ytdPriceChangePercentage);
			coin.setAudited(isAudited);
//			coin.setAuditor(auditor);
//			coin.setAuditStatus(auditStatus);
//			coin.setReportUrl(reportUrl);

			Coin upCoin = coinDao.save(coin);
		}

	}

	@Scheduled(initialDelay = 3000, fixedRate = 20000)
	@GetMapping("coin/getAll")
	public List<Coin> findAllcoin() {
		List<Coin> allCoinList = coinDao.findAll();
		return allCoinList;
	}

	@GetMapping("coin/page/{pageNumber}")
	public List<Coin> findByPage(@PathVariable Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "id");

		Page<Coin> page = coinDao.findAll(pgb);

		List<Coin> list = page.getContent();

		return list;
	}
}



