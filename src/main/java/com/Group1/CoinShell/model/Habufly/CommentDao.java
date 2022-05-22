package com.Group1.CoinShell.model.Habufly;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {
	
	// HQL
//		@Query("from Comment where name = :name")
//		public List<Comment> findCommentByName(@Param("name") String name);

		// 原生 SQL (nativeQuery = true)
//		@Query(value = "select * from comment where type = :type", nativeQuery = true)
//		public List<Comment> findCommentByType(@Param("type") String type);

//		@Query(value = "select * from comment where name = :name and level = :level", nativeQuery = true)
//		public List<Comment> findCommentByName3(@Param("name") String name, @Param("level") Integer level);

		@Query(value = "select * from comment where article_id = :articleId and type = 'a' and deleted = 'n' ORDER BY added asc", nativeQuery = true)
		public List<Comment> findCommentByAtcAndType(@Param("articleId") Integer articleId);
		
		@Query(value = "select * from comment where article_id = :articleId and comment_Id = :commentId and type = 'b' and deleted = 'n' ORDER BY added asc", nativeQuery = true)
		public List<Comment> findReplyByAtcAndType(@Param("articleId") Integer articleId, @Param("commentId") Integer commentId);
		
		@Query(value = "select count( * ) as count from comment where article_id = :articleId and type = :type", nativeQuery = true)
		public Integer checkCommentNumber(@Param("articleId") Integer articleId, @Param("type") String type);

//		@Query(value = "select * from comment where deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article", nativeQuery = true)
//		public List<Comment> findAllOrderByAddedDesc();
		
//		https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#tansactions

//		@Query(value = "delete from comment where name = ?1", nativeQuery = true)
//		@Transactional // 沒有Service標註此項的話，要在修改資料的地方標註此
//		@Modifying
//		public void deleteCommentByName(String name);
		
//		https://docs.spring.io/spring-date/jpa/docs/current/
//		public List<Comment> findByLevelOrderById(Integer level);
//		public List<Comment> findByLevelOrderByIdDesc(Integer level);
		
		
}
