package com.rbc.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rbc.stock.model.StockData;

public interface StockDataRepository extends CrudRepository<StockData, Integer> {
	
	
	@Query(value="SELECT * FROM stock_data where quarter = :quarter",
			nativeQuery=true)
	List<StockData> findAllDataForQuarter(@Param("quarter") int quarter);


	@Query(value="SELECT * FROM stock_data where quarter = :quarter and stock_id = :stockId ",
			nativeQuery=true)
	List<StockData> findStockDataForQuarter(@Param("quarter") int quarter, @Param("stockId") int stockId);

}
