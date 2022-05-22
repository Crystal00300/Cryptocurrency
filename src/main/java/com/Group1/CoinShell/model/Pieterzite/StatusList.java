package com.Group1.CoinShell.model.Pieterzite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status_list")
public class StatusList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "days")
	private Integer days;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coin")
	private Integer coin;

	public StatusList() {

	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Integer getCoin() {
		return coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusList [days=").append(days).append(", coin=").append(coin).append("]");
		return builder.toString();
	}

}
