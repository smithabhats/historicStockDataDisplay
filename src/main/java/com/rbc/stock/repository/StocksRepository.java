package com.rbc.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rbc.stock.model.Stock;

public interface StocksRepository extends CrudRepository<Stock, Integer> {

	@Query(value="SELECT * FROM stocks", nativeQuery=true)
	List<Stock> findAllStocks();
	
	@Query(value="SELECT * FROM stocks where stock_id=:stockid", nativeQuery=true)
	Stock findStock(@Param("stockid")  int stockid);

}
