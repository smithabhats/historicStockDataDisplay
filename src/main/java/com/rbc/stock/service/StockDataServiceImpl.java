package com.rbc.stock.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.rbc.stock.controller.StockDataController;
import com.rbc.stock.dao.StockDataDao;
import com.rbc.stock.model.StockData;
import com.rbc.stock.repository.StockDataRepository;
import com.rbc.stock.util.StockUtils;

@Service
public class StockDataServiceImpl implements StockDataService {

	@Autowired
	private StockDataRepository dataRepo;
	
	@Autowired
	private StockDataDao stockDao;

    @PersistenceContext
    private EntityManager entityManager;
    
	Logger logger = Logger.getLogger(StockDataController.class);
    
	@Override
	public List<StockData> fetchAllDataForQuarter(int quarter){

		return dataRepo.findAllDataForQuarter(quarter);
	}

	@Override
	public List<StockData> fetchStockDataForQuarter(int quarter, int stockId){

		return dataRepo.findStockDataForQuarter(quarter, stockId);
	}

	@Transactional
	public void insertStockData(StockData stockData) throws Exception{ 
		logger.debug("Entering StockDataServiceImpl.insertStockData()");
		
		stockData.setQuarter(StockUtils.getQuarter(stockData.getTrading_date().toLocalDate()));
		stockData.setPercent_change_price(StockUtils.getPercentChange(stockData.getOpen_price(), stockData.getClosing_price()));
		
		entityManager.merge(stockData);
		entityManager.flush();
		
		logger.debug("Exiting StockDataServiceImpl.insertStockData()");

	}
	
	public boolean uploadBulkData(MultipartFile dataFile) throws Exception{		
		return stockDao.uploadBulkData(dataFile);
	}

}
