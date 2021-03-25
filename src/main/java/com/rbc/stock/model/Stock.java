package com.rbc.stock.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="stocks")
public class Stock  implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="stock_id")
	int stock_id;
	
	@Column(name="stock_name")
	String stock_name;
	
	@Column(name="stock_code")
	String stock_code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
    List<StockData> stockData;

	public List<StockData> getStockData() {
		return stockData;
	}

	public void setStockData(List<StockData> stockData) {
		this.stockData = stockData;
	}

	public Stock() {
		super();
	}

	public int getStock_id() {
		return stock_id;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public String getStock_name() {
		return stock_name;
	}

	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}

	public String getStock_code() {
		return stock_code;
	}

	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}
	
	
}
