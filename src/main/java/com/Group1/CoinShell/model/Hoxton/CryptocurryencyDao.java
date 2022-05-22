package com.Group1.CoinShell.model.Hoxton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocurryencyDao extends JpaRepository<Cryptocurrency,Integer>{
	

	@Query(value="SELECT TOP 1 * FROM cryptocurrency WHERE Symbol_of_Cryptocurrency = :currencyName1 ORDER BY InformationDate DESC",nativeQuery = true)
	public Cryptocurrency findLastestCurrencyInformation(@Param("currencyName1") String currencyName);
	
	@Query(value="SELECT symbol_of_cryptocurrency,(SELECT informationDate FROM Cryptocurrency WHERE CONVERT(varchar,InformationDate,120) = (SELECT MAX(InformationDate) FROM Cryptocurrency WHERE CONVERT(varchar,InformationDate,120) like :day2 AND symbol_of_cryptocurrency=:currencyName2) AND symbol_of_cryptocurrency=:currencyName2) as 'Date1' ,(SELECT informationDate FROM Cryptocurrency WHERE CONVERT(varchar,InformationDate,120) = (SELECT MIN(InformationDate) FROM Cryptocurrency WHERE CONVERT(varchar,InformationDate,120) like '%'+:day2+'%' AND symbol_of_cryptocurrency=:currencyName2) AND symbol_of_cryptocurrency=:currencyName2) as 'Date',(SELECT USD_Price_of_Cryptocurrency FROM Cryptocurrency WHERE CONVERT(varchar,InformationDate,120) = (SELECT MAX(InformationDate) FROM Cryptocurrency WHERE CONVERT(varchar,InformationDate,120) like '%'+:day2+'%' AND symbol_of_cryptocurrency=:currencyName2) AND symbol_of_cryptocurrency=:currencyName2) as 'TheFristUsdDate' ,(SELECT USD_Price_of_Cryptocurrency FROM Cryptocurrency WHERE CONVERT(varchar,InformationDate,120) = (SELECT MIN(InformationDate) FROM Cryptocurrency WHERE CONVERT(varchar,InformationDate,120) like '%'+:day2+'%' AND symbol_of_cryptocurrency=:currencyName2) AND symbol_of_cryptocurrency=:currencyName2) as 'TheLastUsdDate' ,MAX(USD_Price_of_Cryptocurrency) AS 'TheHighestUsdPricePerUnit' ,MIN(USD_Price_of_Cryptocurrency)AS 'TheLowerUsdPricePerUnit' ,MAX(volume24hUsd)AS 'Usd24hVolume' ,MAX(USD_Market_Cap)AS 'UsdMarkCap' ,(SELECT TWD_Price_of_Cryptocurrency FROM Cryptocurrency WHERE CONVERT(varchar,InformationDate,120) = (SELECT MAX(InformationDate) FROM Cryptocurrency WHERE CONVERT(varchar,InformationDate,120) like '%'+:day2+'%' AND symbol_of_cryptocurrency=:currencyName2) AND symbol_of_cryptocurrency=:currencyName2) as 'TheFristTwdDate' ,(SELECT TWD_Price_of_Cryptocurrency FROM Cryptocurrency WHERE CONVERT(varchar,InformationDate,120) = (SELECT MIN(InformationDate) FROM Cryptocurrency WHERE CONVERT(varchar,InformationDate,120) like '%'+:day2+'%' AND symbol_of_cryptocurrency=:currencyName2) AND symbol_of_cryptocurrency=:currencyName2) as 'TheLastTwdDate' ,MAX(TWD_Price_of_Cryptocurrency) AS 'TheHighestTwdPricePerUnit' ,MIN(TWD_Price_of_Cryptocurrency)AS 'TheLowerTwdPricePerUnit'     ,MAX(volume24hTwd)AS  'Twd24hVolume' ,MAX(TWD_Market_Cap) AS 'TwdMarkCap' from Cryptocurrency WHERE   CONVERT(varchar,InformationDate,120) LIKE '%'+:day2+'%' and symbol_of_cryptocurrency =:currencyName2 group by symbol_of_cryptocurrency",nativeQuery = true)
	public List<Map<String,Object>> findHistoricalCurrencyInformation(@Param("currencyName2")String currencyName,@Param("day2")String day);
	//Example:http://localhost:8080/coinshell/historical/get?currencyName=eth&day=2022-05-17

	@Query(value="select * FROM Cryptocurrency WHERE DATEDIFF(dd,InformationDate,GETDATE())<=30 and Symbol_of_Cryptocurrency =:currencyName3",nativeQuery = true)
	public List<Map<String,Object>> find30DaysCurrencyInformation(@Param("currencyName3")String currencyName);
	//返回指定幣別30天的的json資料
	
	@Query(value="select  InformationDate FROM Cryptocurrency WHERE DATEDIFF(dd,InformationDate,GETDATE())<=30 and Symbol_of_Cryptocurrency =:currencyName3",nativeQuery = true)
	public List<String> find30DaysCurrencyInformationDate(@Param("currencyName3")String currencyName);
	//返回指定幣別30天的的json日期資料
	
	@Query(value="select  USD_Price_of_Cryptocurrency FROM Cryptocurrency WHERE DATEDIFF(dd,InformationDate,GETDATE())<=30 and Symbol_of_Cryptocurrency =:currencyName3",nativeQuery = true)
	public List<String> find30DaysCurrencyUsdPrice(@Param("currencyName3")String currencyName);
	//返回指定幣別30天的的json日期資料
	


	
}