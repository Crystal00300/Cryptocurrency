package com.Group1.CoinShell.model.Hoxton;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="commodity")
public class Commodity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="commodity_name",nullable = false)
	private String commodityName;
	
	@Column(name="price",nullable = false)
	private Integer price;
	
	@Column(name="myshell",nullable = false)
	private Integer myShell;
	
	@Column(name="volume",nullable = false)
	private Integer volume;
	
	@Column(name="photo",columnDefinition = "NVARCHAR(MAX)",nullable = false)
	private String photo;
	
	@Column(name="discribe",nullable = false)
	private String discribe;
	
	@Column(name="shell_or_coin",nullable = false)
	private String shellOrCoin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getMyShell() {
		return myShell;
	}

	public void setMyShell(Integer myShell) {
		this.myShell = myShell;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public String getShellOrCoin() {
		return shellOrCoin;
	}

	public void setShellOrCoin(String shellOrCoin) {
		this.shellOrCoin = shellOrCoin;
	}

	public Commodity(Integer id, String commodityName, Integer price, Integer myShell, Integer volume, String photo,
			String discribe, String shellOrCoin) {
		super();
		this.id = id;
		this.commodityName = commodityName;
		this.price = price;
		this.myShell = myShell;
		this.volume = volume;
		this.photo = photo;
		this.discribe = discribe;
		this.shellOrCoin = shellOrCoin;
	}

	public Commodity() {
	}
	
	
	
	

		
}
