package com.rbc.stock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.rbc.stock.repository.StockDataRepository;
import com.rbc.stock.service.StockDataService;
import com.rbc.stock.service.StockDataServiceImpl;
@SpringBootTest
public class StockDataServiceImplIntegrationTest {
//////////Yet to be implemented
	
	@Autowired
	private StockDataService stockService;
	
	@MockBean
	private StockDataRepository stockRepository;
	
	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {
		@Bean
		public StockDataService employeeService() {

			return new StockDataServiceImpl();
		};
	}


}
