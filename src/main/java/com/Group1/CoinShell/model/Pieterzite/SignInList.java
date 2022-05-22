package com.Group1.CoinShell.model.Pieterzite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sign_in_list")
public class SignInList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss EEEE")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")  // 從資料庫取出後轉格式
	@Temporal(TemporalType.TIMESTAMP)  // 存進去的資料型別
	@Column(name="sign_in_time", columnDefinition ="datetime")
	private Date signIntime;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status")
	private Integer status;

	public SignInList() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getSign_in_time() {
		return signIntime;
	}

	public void setSign_in_time(Date sign_in_time) {
		this.signIntime = sign_in_time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SignInList [id=").append(id).append(", sign_in_time=").append(signIntime).append(", status=")
				.append(status).append("]");
		return builder.toString();
	}

}

