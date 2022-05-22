package com.Group1.CoinShell.model.Habufly;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {
	
	public Article findFirstByOrderByAddedDesc();

	@Query(value = "select * from article where tag = :tag and deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article where tag = :tag", nativeQuery = true)
	public Page<Article> findByTag(Pageable page, @Param("tag") String tag);
//	 實際查詢過程中，需使用註釋來避免sql文報錯，增加以下「countQuery = "select count (*) from article where tag = :tag",」

	@Query(value = "select * from article where tag = :tag and deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article where tag = :tag", nativeQuery = true)
	public List<Article> findByTag(String tag);
	
//	@Query(value = "select * from article where CHARINDEX(:titlePart, title) > 0", countQuery = "select count (*) from article where CHARINDEX(:titlePart, title) > 0", nativeQuery = true)
	@Query(value = "select * from article where title like %?1% or text like %?1% and deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article where title like %?1% or text like %?1%", nativeQuery = true)
	public List<Article> findByTitle(String titlePart);

	@Query(value = "select * from article where deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article", nativeQuery = true)
	public List<Article> findAllOrderByAddedDesc();
	
}
