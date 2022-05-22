package com.Group1.CoinShell.model.Habufly;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="article")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="author_Id")
	private Integer authorId;
	
	@Column(name="title", columnDefinition = "nvarchar(50)")//預設是varchar(255)，因為可能有中文改為nvarchar
	private String title;
	
	@Column(name="text", columnDefinition = "nvarchar(MAX)")//預設是varchar(255)，因為可能有中文改為nvarchar
	private String text;
	
	@Column(name="peek", columnDefinition = "nvarchar(200)")//預設是varchar(255)，因為可能有中文改為nvarchar
	private String peek;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")//M指月份m指分鐘//這是丟出來的資料型態
	@Temporal(TemporalType.TIMESTAMP)//這是存進去的資料型態
	@Column(name="added", columnDefinition = "datetime")
	private Date added;
	
	@Column(name="tag", columnDefinition = "nvarchar(20)")
	private String tag;
	
	@Column(name="read_Num", nullable=false, columnDefinition = "INT default 0")
    private Integer readNum;
    
	@Column(name="comment_Num", nullable=false, columnDefinition = "INT default 0")
    private Integer commentNum;
    
	@Column(name="deleted", columnDefinition = "varchar(2) default 'n'")
    private String deleted;
	
	public Article() {
	}

	@PrePersist //物件狀態轉換到 persist 之前，要做的事情
	public void onCreate() {
		if(added==null) {
			added = new Date();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer author_Id) {
		this.authorId = author_Id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPeek() {
		return peek;
	}

	public void setPeek(String peek) {
		this.peek = peek;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getReadNum() {
		return readNum;
	}

	public void setReadNum(Integer read_Num) {
		this.readNum = read_Num;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer comment_Num) {
		this.commentNum = comment_Num;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [id=");
		builder.append(id);
		builder.append(", author_Id=");
		builder.append(authorId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", text=");
		builder.append(text);
		builder.append(", peek=");
		builder.append(peek);
		builder.append(", added=");
		builder.append(added);
		builder.append(", tag=");
		builder.append(tag);
		builder.append(", read_Num=");
		builder.append(readNum);
		builder.append(", comment_Num=");
		builder.append(commentNum);
		builder.append(", deleted=");
		builder.append(deleted);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
