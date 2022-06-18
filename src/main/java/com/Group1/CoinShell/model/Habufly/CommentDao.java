package com.Group1.CoinShell.model.Habufly;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {		
		/**
		 * 查詢未刪除的評論+個人圖片
		 * */
		@Query(value = "select c.id,added,article_id as articleId,comment_id as commentId,deleted,text,type,user_name as userName,user_id as userId,ava.userAvatar "
				+ "from comment as c "
				+ "left join "
				+ "(Members as m inner join CustomizedUserAvatar as ava on m.customizedUserAvatar = ava.id) "
				+ "on c.user_id = m.id where article_id = :articleId and type = 'a' and deleted = 'n' ORDER BY added desc", nativeQuery = true)
		public List<Map<String,Object>> findCommentByAtcAndType(@Param("articleId") Integer articleId);
		
		/**
		 * 查詢所有評論+個人圖片
		 * */
		@Query(value = "select c.id,added,article_id as articleId,comment_id as commentId,deleted,text,type,user_name as userName,user_id as userId,ava.userAvatar "
				+ "from comment as c "
				+ "left join "
				+ "(Members as m inner join CustomizedUserAvatar as ava on m.customizedUserAvatar = ava.id) "
				+ "on c.user_id = m.id where article_id = :articleId and type = 'a' ORDER BY added desc", nativeQuery = true)
		public List<Map<String,Object>> findCommentByAtcAndTypeAdmin(@Param("articleId") Integer articleId);
		
		/**
		 * 查詢未刪除的回覆+個人圖片
		 * */
		@Query(value = "select c.id,added,article_id as articleId,comment_id as commentId,deleted,text,type,user_name as userName,user_id as userId,ava.userAvatar "
				+ "from comment as c "
				+ "left join "
				+ "(Members as m inner join CustomizedUserAvatar as ava on m.customizedUserAvatar = ava.id) "
				+ "on c.user_id = m.id where article_id = :articleId and comment_Id = :commentId and type = 'b' and deleted = 'n' ORDER BY added desc", nativeQuery = true)
		public List<Map<String,Object>> findReplyByAtcAndType(@Param("articleId") Integer articleId, @Param("commentId") Integer commentId);
		
		/**
		 * 查詢所有回覆+個人圖片
		 * */
		@Query(value = "select c.id,added,article_id as articleId,comment_id as commentId,deleted,text,type,user_name as userName,user_id as userId,ava.userAvatar "
				+ "from comment as c "
				+ "left join "
				+ "(Members as m inner join CustomizedUserAvatar as ava on m.customizedUserAvatar = ava.id) "
				+ "on c.user_id = m.id where article_id = :articleId and comment_Id = :commentId and type = 'b' ORDER BY added desc", nativeQuery = true)
		public List<Map<String,Object>> findReplyByAtcAndTypeAdmin(@Param("articleId") Integer articleId, @Param("commentId") Integer commentId);
		
		/**
		 * 取得評論數
		 * */
		@Query(value = "select count( * ) as count from comment where article_id = :articleId and type = :type and deleted = 'n'", nativeQuery = true)
		public Integer checkCommentNum(@Param("articleId") Integer articleId, @Param("type") String type);

		/**
		 * 取得特定評論或回覆+個人圖片
		 * */
		@Query(value = "select c.id,added,article_id as articleId,comment_id as commentId,deleted,text,type,user_name as userName,user_id as userId,ava.userAvatar,user_email as userEmail "
				+ "from comment as c "
				+ "left join "
				+ "(Members as m inner join CustomizedUserAvatar as ava on m.customizedUserAvatar = ava.id) "
				+ "on c.user_id = m.id where c.id = :id", nativeQuery = true)
		public List<Map<String,Object>> findCRById(@Param("id")Integer id);

		/**
		 * 將特定評論/回覆轉為"刪除"狀態
		 * */
		@Query(value = "update comment set deleted = 'y' where id = :id", nativeQuery = true)
		public void deleteCR(Integer id);

		/**
		 * 將特定評論/回覆轉為"存活"狀態
		 * */
		@Query(value = "update comment set deleted = 'n' where id = :id", nativeQuery = true)
		public void undoCR(Integer id);

		/**
		 * 查詢特定評論/回覆
		 * */
		@Query(value = "select * from comment where id = :id", nativeQuery = true)
		public Comment findCommById(Integer id);
		
//		https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#tansactions

//		@Query(value = "delete from comment where name = ?1", nativeQuery = true)
//		@Transactional // 沒有Service標註此項的話，要在修改資料的地方標註此
//		@Modifying
//		public void deleteCommentByName(String name);
		
//		https://docs.spring.io/spring-date/jpa/docs/current/
//		public List<Comment> findByLevelOrderById(Integer level);
//		public List<Comment> findByLevelOrderByIdDesc(Integer level);
		
		
}
