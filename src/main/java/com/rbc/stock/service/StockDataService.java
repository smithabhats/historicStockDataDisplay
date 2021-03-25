package com.rbc.stock.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rbc.stock.model.StockData;

public interface StockDataService {
	
	public List<StockData> fetchAllDataForQuarter(int quarter);

	public List<StockData> fetchStockDataForQuarter(int quarter, int stockId);
	
	public void insertStockData(StockData stockData) throws Exception;
	
	public boolean uploadBulkData(MultipartFile dataFile) throws Exception;

}
