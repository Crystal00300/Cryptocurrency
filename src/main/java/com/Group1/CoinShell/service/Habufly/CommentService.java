package com.Group1.CoinShell.service.Habufly;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Group1.CoinShell.model.Habufly.Comment;
import com.Group1.CoinShell.model.Habufly.CommentDao;

@Service
public class CommentService {

	@Autowired
	private CommentDao dao;
	
	public void inserComm(Comment comm) {
		dao.save(comm);
	}

	public List<Map<String,Object>> selectComm(Integer articleId) {
		List<Map<String,Object>> comm = dao.findCommentByAtcAndType(articleId);
		return comm;
	}

	public List<Map<String,Object>> selectReply(Integer articleId, Integer commentId) {
		List<Map<String,Object>> reply = dao.findReplyByAtcAndType(articleId, commentId);
		return reply;
	}
	
	public List<Map<String,Object>> selectCommAdmin(Integer articleId) {
		List<Map<String,Object>> comm = dao.findCommentByAtcAndTypeAdmin(articleId);
		return comm;
	}

	public List<Map<String,Object>> selectReplyAdmin(Integer articleId, Integer commentId) {
		List<Map<String,Object>> reply = dao.findReplyByAtcAndTypeAdmin(articleId, commentId);
		return reply;
	}
	
	public Integer checkCommentNum(Integer article_id, String type) {
		Integer commNum = dao.checkCommentNum(article_id, type);
		return commNum;
	}

	public List<Map<String, Object>> findCRById(Integer cid) {
		List<Map<String, Object>> cR = dao.findCRById(cid);
		return cR;
	}

	public void delete(Integer id) {
		dao.deleteCR(id);
	}

	public void undoCR(Integer id) {
		dao.undoCR(id);
	}

	public Comment findById(Integer id) {
		Comment comm = dao.findCommById(id);
		return comm;
	}
	
}
