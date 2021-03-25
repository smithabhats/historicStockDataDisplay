package com.rbc.stock;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rbc.stock.controller.StockDataController;

@SpringBootTest
class RbcStockAppApplicationTests {

	@Autowired
	private StockDataController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
