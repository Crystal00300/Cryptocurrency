package com.Group1.CoinShell.model.Pieterzite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusListDao extends JpaRepository<StatusList, Integer> {
	
	@Query(value="SELECT * FROM StatusList WHERE days =: days01",nativeQuery = true)
	public StatusList findByDays(@Param("days01")Integer days);
}