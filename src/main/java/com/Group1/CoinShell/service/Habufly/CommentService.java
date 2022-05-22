package com.Group1.CoinShell.service.Habufly;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Group1.CoinShell.model.Habufly.ArticleDao;
import com.Group1.CoinShell.model.Habufly.Comment;
import com.Group1.CoinShell.model.Habufly.CommentDao;



@Service
public class CommentService {

	@Autowired
	private CommentDao dao;
	@Autowired
	private ArticleDao adao;
	
	public void inserComm(Comment comm) {
		dao.save(comm);
	}

	public List<Comment> selectComm(Integer articleId) {
		List<Comment> comm = dao.findCommentByAtcAndType(articleId);
		return comm;
	}

	public List<Comment> selectReply(Integer articleId, Integer commentId) {
		List<Comment> comm = dao.findReplyByAtcAndType(articleId, commentId);
		return comm;
	}
	
	public Page<Comment> findByPage(Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC, "added");
		Page<Comment> page = dao.findAll(pgb);
		return page;
	}
	
	public Integer checkCommentNum(Integer article_id, String type) {
		Integer commNum = dao.checkCommentNumber(article_id, type);
		return commNum;
	}

//	public List<Comment> findAll(Integer aid) {
//		return dao.findAllOrderByAddedDesc();
//	}
	
//	public void increaseArticleComment(Integer articleId) {
//        Article article = adao.getById(articleId);
//        Integer CommentNum = article.getCommentNum();
//        article.setCommentNum(CommentNum+1);
//	}
	
}
