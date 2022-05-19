package com.Group1.CoinShell.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinDao extends JpaRepository<Coin, Integer> {

	
	@Query(value="select * from coin where symbol =:currencyName3",nativeQuery = true)
	public Coin findLastestCurrencyInformation(@Param("currencyName3")String currencyName); 
		
}
