package Group1.MyShell.grabJsonToSqlDatabase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Group1.MyShell.MVC.model.CryptocurrencyBean;
import Group1.MyShell.util.HibernateUtils;

public class grabJsonToSqlDatabase {
	public static void main(String[] args) throws IOException {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		for (int day = 17; day < 29; day++) {
			

			String TWD_filePath = "C:\\Json\\TWD\\2022-04-" + day + ".txt";
			String USD_filePath = "C:\\Json\\USD\\2022-04-" + day + ".txt";
			String CNY_filePath = "C:\\Json\\CNY\\2022-04-" + day + ".txt";
			String JPY_filePath = "C:\\Json\\JPY\\2022-04-" + day + ".txt";
			String EUR_filePath = "C:\\Json\\EUR\\2022-04-" + day + ".txt";

			String fileContent;

			FileReader TWDfile = new FileReader(TWD_filePath);
			FileReader USDfile = new FileReader(USD_filePath);
			FileReader CNYfile = new FileReader(CNY_filePath);
			FileReader JPYfile = new FileReader(JPY_filePath);
			FileReader EURfile = new FileReader(EUR_filePath);

			BufferedReader TWDbr = new BufferedReader(TWDfile);
			BufferedReader USDbr = new BufferedReader(USDfile);
			BufferedReader CNYbr = new BufferedReader(CNYfile);
			BufferedReader JPYbr = new BufferedReader(JPYfile);
			BufferedReader EURbr = new BufferedReader(EURfile);

			StringBuffer TWDsr = new StringBuffer();
			StringBuffer USDsr = new StringBuffer();
			StringBuffer CNYsr = new StringBuffer();
			StringBuffer JPYsr = new StringBuffer();
			StringBuffer EURsr = new StringBuffer();

			while ((fileContent = TWDbr.readLine()) != null) {
				TWDsr.append(fileContent);
			}
			while ((fileContent = USDbr.readLine()) != null) {
				USDsr.append(fileContent);
			}
			while ((fileContent = CNYbr.readLine()) != null) {
				CNYsr.append(fileContent);
			}
			while ((fileContent = JPYbr.readLine()) != null) {
				JPYsr.append(fileContent);
			}
			while ((fileContent = EURbr.readLine()) != null) {
				EURsr.append(fileContent);
			}

			ObjectMapper mapper = new ObjectMapper();
			JsonNode TWDnode = mapper.readTree(TWDsr.toString());
			JsonNode USDnode = mapper.readTree(USDsr.toString());
			JsonNode CNYnode = mapper.readTree(CNYsr.toString());
			JsonNode JPYnode = mapper.readTree(JPYsr.toString());
			JsonNode EURnode = mapper.readTree(EURsr.toString());

			String data = TWDnode.get("data").toString();

			JSONArray jArray = new JSONArray(data);
			for (int i = 0; i < jArray.length(); i++) {
				CryptocurrencyBean crypto = new CryptocurrencyBean();
				String date = TWDnode.get("status").get("timestamp").asText().substring(0, 10);
				String nameOfCryptocurrency = TWDnode.get("data").get(i).get("name").asText();
				String symbolOfCryptocurrency = TWDnode.get("data").get(i).get("symbol").asText();
				String slugOfCryptocurrency = TWDnode.get("data").get(i).get("slug").asText();
				int maxSupply = TWDnode.get("data").get(i).get("max_supply").asInt();
				int circulatingSupply = TWDnode.get("data").get(i).get("circulating_supply").asInt();
				double percentChange1h = TWDnode.get("data").get(i).get("quote").get("TWD").get("percent_change_1h")
						.asDouble();
				double percentChange24h = TWDnode.get("data").get(i).get("quote").get("TWD").get("percent_change_24h")
						.asDouble();
				double percentChange7d = TWDnode.get("data").get(i).get("quote").get("TWD").get("percent_change_7d")
						.asDouble();
				double percentChange30d = TWDnode.get("data").get(i).get("quote").get("TWD").get("percent_change_30d")
						.asDouble();
				double percentChange60d = TWDnode.get("data").get(i).get("quote").get("TWD").get("percent_change_60d")
						.asDouble();
				double percentChange90d = TWDnode.get("data").get(i).get("quote").get("TWD").get("percent_change_90d")
						.asDouble();

				double TWDpriceOfCryptocurrency = TWDnode.get("data").get(i).get("quote").get("TWD").get("price")
						.asDouble();
				double TWDmarketCap = TWDnode.get("data").get(i).get("quote").get("TWD").get("market_cap").asDouble();
				double TWDfullyDilutedMarketCap = TWDnode.get("data").get(i).get("quote").get("TWD")
						.get("fully_diluted_market_cap").asDouble();

				double USDpriceOfCryptocurrency = USDnode.get("data").get(i).get("quote").get("USD").get("price")
						.asDouble();
				double USDmarketCap = USDnode.get("data").get(i).get("quote").get("USD").get("market_cap").asDouble();
				double USDfullyDilutedMarketCap = USDnode.get("data").get(i).get("quote").get("USD")
						.get("fully_diluted_market_cap").asDouble();

				double CNYpriceOfCryptocurrency = CNYnode.get("data").get(i).get("quote").get("CNY").get("price")
						.asDouble();
				double CNYmarketCap = CNYnode.get("data").get(i).get("quote").get("CNY").get("market_cap").asDouble();
				double CNYfullyDilutedMarketCap = CNYnode.get("data").get(i).get("quote").get("CNY")
						.get("fully_diluted_market_cap").asDouble();

				double JPYpriceOfCryptocurrency = JPYnode.get("data").get(i).get("quote").get("JPY").get("price")
						.asDouble();
				double JPYmarketCap = JPYnode.get("data").get(i).get("quote").get("JPY").get("market_cap").asDouble();
				double JPYfullyDilutedMarketCap = JPYnode.get("data").get(i).get("quote").get("JPY")
						.get("fully_diluted_market_cap").asDouble();

				double EURpriceOfCryptocurrency = EURnode.get("data").get(i).get("quote").get("EUR").get("price")
						.asDouble();
				double EURmarketCap = EURnode.get("data").get(i).get("quote").get("EUR").get("market_cap").asDouble();
				double EURfullyDilutedMarketCap = EURnode.get("data").get(i).get("quote").get("EUR")
						.get("fully_diluted_market_cap").asDouble();

				crypto.setDate(date);
				crypto.setNameOfCryptocurrency(nameOfCryptocurrency);
				crypto.setSymbolOfCryptocurrency(symbolOfCryptocurrency);
				crypto.setSlugOfCryptocurrency(slugOfCryptocurrency);
				crypto.setMaxSupply(maxSupply);
				crypto.setCirculatingSupply(circulatingSupply);
				crypto.setPercentChange1h(percentChange1h);
				crypto.setPercentChange24h(percentChange24h);
				crypto.setPercentChange7d(percentChange7d);
				crypto.setPercentChange30d(percentChange30d);
				crypto.setPercentChange60d(percentChange60d);
				crypto.setPercentChange90d(percentChange90d);

				crypto.setTWDpriceOfCryptocurrency(TWDpriceOfCryptocurrency);
				crypto.setTWDmarketCap(TWDmarketCap);
				crypto.setTWDfullyDilutedMarketCap(TWDfullyDilutedMarketCap);

				crypto.setUSDpriceOfCryptocurrency(USDpriceOfCryptocurrency);
				crypto.setUSDmarketCap(USDmarketCap);
				crypto.setUSDfullyDilutedMarketCap(USDfullyDilutedMarketCap);

				crypto.setCNYpriceOfCryptocurrency(CNYpriceOfCryptocurrency);
				crypto.setCNYmarketCap(CNYmarketCap);
				crypto.setCNYfullyDilutedMarketCap(CNYfullyDilutedMarketCap);

				crypto.setJPYpriceOfCryptocurrency(JPYpriceOfCryptocurrency);
				crypto.setJPYmarketCap(JPYmarketCap);
				crypto.setJPYfullyDilutedMarketCap(JPYfullyDilutedMarketCap);

				crypto.setEURpriceOfCryptocurrency(EURpriceOfCryptocurrency);
				crypto.setEURmarketCap(EURmarketCap);
				crypto.setEURfullyDilutedMarketCap(EURfullyDilutedMarketCap);
				session.beginTransaction();
				session.save(crypto);
				System.out.println(crypto);
				session.getTransaction().commit();
				
			}
		}
	}

}