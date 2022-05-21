package com.Group1.CoinShell.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "News")
public class News {

	public News() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@UpdateTimestamp
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Upload_Time")
	private Date date;

	@Column(name = "title")
	private String title;

	@Column(name = "Content_Of_News")
	private String contentOfNews;

	@Column(name = "Image_Of_News", columnDefinition = "NVARCHAR(MAX)")
	private String imageOfNews;

	@Column(name = "Relevant_Currency1")
	private String Relevant_Currency1;
	
	@Column(name = "Relevant_Currency2")
	private String Relevant_Currency2;
	
	@Column(name = "Relevant_Currency3")
	private String Relevant_Currency3;
	
	@Column(name = "Relevant_Currency4")
	private String Relevant_Currency4;
	
	@Column(name = "Relevant_Currency5")
	private String Relevant_Currency5;
	
	@Column(name = "Relevant_Currency6")
	private String Relevant_Currency6;
	
	@Column(name = "Relevant_Currency7")
	private String Relevant_Currency7;
	
	@Column(name = "Relevant_Currency8")
	private String Relevant_Currency8;
	
	@Column(name = "Relevant_Currency9")
	private String Relevant_Currency9;
	
	@Column(name = "Relevant_Currency10")
	private String Relevant_Currency10;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentOfNews() {
		return contentOfNews;
	}

	public void setContentOfNews(String contentOfNews) {
		this.contentOfNews = contentOfNews;
	}

	public String getImageOfNews() {
		return imageOfNews;
	}

	public void setImageOfNews(String imageOfNews) {
		this.imageOfNews = imageOfNews;
	}

	public String getRelevant_Currency1() {
		return Relevant_Currency1;
	}

	public void setRelevant_Currency1(String relevant_Currency1) {
		Relevant_Currency1 = relevant_Currency1;
	}

	public String getRelevant_Currency2() {
		return Relevant_Currency2;
	}

	public void setRelevant_Currency2(String relevant_Currency2) {
		Relevant_Currency2 = relevant_Currency2;
	}

	public String getRelevant_Currency3() {
		return Relevant_Currency3;
	}

	public void setRelevant_Currency3(String relevant_Currency3) {
		Relevant_Currency3 = relevant_Currency3;
	}

	public String getRelevant_Currency4() {
		return Relevant_Currency4;
	}

	public void setRelevant_Currency4(String relevant_Currency4) {
		Relevant_Currency4 = relevant_Currency4;
	}

	public String getRelevant_Currency5() {
		return Relevant_Currency5;
	}

	public void setRelevant_Currency5(String relevant_Currency5) {
		Relevant_Currency5 = relevant_Currency5;
	}

	public String getRelevant_Currency6() {
		return Relevant_Currency6;
	}

	public void setRelevant_Currency6(String relevant_Currency6) {
		Relevant_Currency6 = relevant_Currency6;
	}

	public String getRelevant_Currency7() {
		return Relevant_Currency7;
	}

	public void setRelevant_Currency7(String relevant_Currency7) {
		Relevant_Currency7 = relevant_Currency7;
	}

	public String getRelevant_Currency8() {
		return Relevant_Currency8;
	}

	public void setRelevant_Currency8(String relevant_Currency8) {
		Relevant_Currency8 = relevant_Currency8;
	}

	public String getRelevant_Currency9() {
		return Relevant_Currency9;
	}

	public void setRelevant_Currency9(String relevant_Currency9) {
		Relevant_Currency9 = relevant_Currency9;
	}

	public String getRelevant_Currency10() {
		return Relevant_Currency10;
	}

	public void setRelevant_Currency10(String relevant_Currency10) {
		Relevant_Currency10 = relevant_Currency10;
	}

	public News(Integer id, Date date, String title, String contentOfNews, String imageOfNews,
			String relevant_Currency1, String relevant_Currency2, String relevant_Currency3, String relevant_Currency4,
			String relevant_Currency5, String relevant_Currency6, String relevant_Currency7, String relevant_Currency8,
			String relevant_Currency9, String relevant_Currency10) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.contentOfNews = contentOfNews;
		this.imageOfNews = imageOfNews;
		Relevant_Currency1 = relevant_Currency1;
		Relevant_Currency2 = relevant_Currency2;
		Relevant_Currency3 = relevant_Currency3;
		Relevant_Currency4 = relevant_Currency4;
		Relevant_Currency5 = relevant_Currency5;
		Relevant_Currency6 = relevant_Currency6;
		Relevant_Currency7 = relevant_Currency7;
		Relevant_Currency8 = relevant_Currency8;
		Relevant_Currency9 = relevant_Currency9;
		Relevant_Currency10 = relevant_Currency10;
	}
	
	
	

}
