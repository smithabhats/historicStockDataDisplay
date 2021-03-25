package com.rbc.stock.dao;

import org.springframework.web.multipart.MultipartFile;

public interface StockDataDao {
	
	public boolean uploadBulkData(MultipartFile dataFile) throws Exception;

	
}
