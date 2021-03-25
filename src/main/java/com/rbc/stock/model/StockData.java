package com.rbc.stock.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="stock_data")
@IdClass(StockDataId.class)
public class StockData  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="quarter")
	private Integer quarter;
	
	@Id
	@Column(name="stock_id")
	private Integer stock_id;
	
	@Id
	@Column(name="trading_date")
	@JsonFormat(pattern="mm/dd/yyyy")
	private Date trading_date;
	
	@Column(name="open_price")
	private Float open_price;
	
	@Column(name="highest")
	private Float highest;
	
	@Column(name="lowest")
	private Float lowest;
	
	@Column(name="closing_price")
	private Float closing_price;
	
	@Column(name="volume")
	private Long volume;
		
	@Column(name="percent_change_price")
	private Float percent_change_price;
	
	@Column(name="days_to_next_dividend")
	private Integer days_to_next_dividend;
	
	@Column(name="percent_return_next_dividend")
	private Float percent_return_next_dividend;
	
	public StockData(Integer quarter, Integer stock_id,
			Date trading_date, Float open_price,
			Float highest, Float lowest, Float closing_price, Long volume, Float percent_change_price,
			Integer days_to_next_dividend, Float percent_return_next_dividend) {
		super();
		this.quarter = quarter;
		this.stock_id = stock_id;
		this.trading_date = trading_date;
		this.open_price = open_price;
		this.highest = highest;
		this.lowest = lowest;
		this.closing_price = closing_price;
		this.volume = volume;
		this.percent_change_price = percent_change_price;
		this.days_to_next_dividend = days_to_next_dividend;
		this.percent_return_next_dividend = percent_return_next_dividend;
	}

	public StockData() {
		super();
	}
	
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_id",insertable=false,updatable=false)
    Stock stock;

    
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Integer getQuarter() {
		return quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	public Integer getStock_id() {
		return stock_id;
	}

	public void setStock_id(Integer stock_id) {
		this.stock_id = stock_id;
	}

	public Date getTrading_date() {
		return trading_date;
	}

	public void setTrading_date(Date trading_date) {
		this.trading_date = trading_date;
	}

	public Float getOpen_price() {
		return open_price;
	}

	public void setOpen_price(Float open_price) {
		this.open_price = open_price;
	}

	public Float getHighest() {
		return highest;
	}

	public void setHighest(Float highest) {
		this.highest = highest;
	}

	public Float getLowest() {
		return lowest;
	}

	public void setLowest(Float lowest) {
		this.lowest = lowest;
	}

	public Float getClosing_price() {
		return closing_price;
	}

	public void setClosing_price(Float closing_price) {
		this.closing_price = closing_price;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}


	public Float getPercent_change_price() {
		return percent_change_price;
	}

	public void setPercent_change_price(Float percent_change_price) {
		this.percent_change_price = percent_change_price;
	}

	public Integer getDays_to_next_dividend() {
		return days_to_next_dividend;
	}

	public void setDays_to_next_dividend(Integer days_to_next_dividend) {
		this.days_to_next_dividend = days_to_next_dividend;
	}

	public Float getPercent_return_next_dividend() {
		return percent_return_next_dividend;
	}

	public void setPercent_return_next_dividend(Float percent_return_next_dividend) {
		this.percent_return_next_dividend = percent_return_next_dividend;
	}
	
}
