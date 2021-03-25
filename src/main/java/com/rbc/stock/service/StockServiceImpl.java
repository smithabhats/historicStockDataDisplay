package com.rbc.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbc.stock.model.Stock;
import com.rbc.stock.repository.StocksRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StocksRepository repo;
	

	@Override
	public List<Stock> fetchAllStocks() {

		return repo.findAllStocks();
	}
	
	@Override
	public Stock fetchStock(int stockId) {

		return repo.findStock(stockId);
	}

}
