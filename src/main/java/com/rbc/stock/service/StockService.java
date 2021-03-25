package com.rbc.stock.service;

import java.util.List;

import com.rbc.stock.model.Stock;

public interface StockService {
	
	public List<Stock> fetchAllStocks();
	
	public Stock fetchStock(int stockId);

}
