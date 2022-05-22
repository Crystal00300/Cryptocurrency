package com.Group1.CoinShell.model.Pieterzite;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SignInListDao extends JpaRepository<SignInList, Integer> {

	@Query(value="SELECT * FROM sign_in_list LEFT JOIN status_list\r\n"
			+ "ON sign_in_list.status = status_list.days\r\n"
			+ "WHERE id=:id01", nativeQuery = true)
	public List<Map<String,Object>> findlogindaysById(@Param("id01") Integer id);
}
