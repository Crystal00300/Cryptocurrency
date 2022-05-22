package com.Group1.CoinShell.service.Habufly;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.CoinShell.model.Habufly.Article;
import com.Group1.CoinShell.model.Habufly.ArticleDao;



@Service
@Transactional
public class ArticleService {
	
	@Autowired
	private ArticleDao dao;
	
	public void save(Article atc) {
		dao.save(atc);
	}
	
	public Article getFirstNewArticle() {
		return dao.findFirstByOrderByAddedDesc();
	}
	
	public List<Article> findAll(){
		return dao.findAllOrderByAddedDesc();
	}
	
	public Page<Article> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC, "added");
		Page<Article> page = dao.findAll(pgb);
		return page;
	}
	
	public Article findById(Integer id) {
		Optional<Article> option = dao.findById(id);
		if(option.isPresent()) {
			Article atc = option.get();
			return atc;
		}
		return null; 
	}

	public void delete(Article atc) {
		dao.delete(atc);
	}

	public void increasePageView(HttpSession session, Integer articleId) {
        Article article = dao.getById(articleId);
        Integer read_Num = article.getReadNum();
        article.setReadNum(read_Num+1);
	}
	
	public void updatCommentNum(Integer articleId, Integer CommentNum) {
		Article article = dao.getById(articleId);
		article.setCommentNum(CommentNum);
	}

	public Page<Article> findByPageAndTag(Integer pageNumber, String tag) {
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC, "added");
		Page<Article> page = dao.findByTag(pgb, tag);
		return page;
	}

	public List<Article> findByTag(String tag) {
		List<Article> list = dao.findByTag(tag);
		return list;
	}

	public List<Article> findByTitle(String titlePart) {
		List<Article> list = dao.findByTitle(titlePart);
		return list;
	}
	
	

}
