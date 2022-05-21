package com.Group1.CoinShell.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface NewsDao extends JpaRepository <News, Integer>{
	
	@Query(value="SELECT * FROM news ",nativeQuery = true)
	public List<News> findAllNews();
	
	@Query(value="SELECT TOP 5 * FROM news WHERE Relevant_Currency1=:currencyName2 OR Relevant_Currency2=:currencyName2 OR Relevant_Currency3=:currencyName2 OR Relevant_Currency4=:currencyName2 OR Relevant_Currency5=:currencyName2 OR Relevant_Currency6=:currencyName2 OR Relevant_Currency7=:currencyName2 OR Relevant_Currency8=:currencyName2 OR Relevant_Currency9=:currencyName2 OR Relevant_Currency10=:currencyName2 ORDER BY Upload_Time DESC",nativeQuery = true)
	public List<News> findAllNewsByCurrencyName(@Param("currencyName2")String currencyName);
}
