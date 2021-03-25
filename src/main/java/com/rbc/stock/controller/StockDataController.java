package com.rbc.stock.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.rbc.stock.model.Stock;
import com.rbc.stock.model.StockData;
import com.rbc.stock.service.StockDataService;
import com.rbc.stock.service.StockService;

@Controller
public class StockDataController {

	@Autowired
	StockDataService stockDataService;

	@Autowired
	StockService stockService;

	Logger logger = Logger.getLogger(StockDataController.class);

	@ModelAttribute("stockData")
	public StockData getGreetingObject() {
		return new StockData();
	}

	@GetMapping("/home")
	public String displayHomePage(ModelMap model) {
		logger.debug("Entering StockDataController.displayHomePage()");

		List<Stock> stocks = stockService.fetchAllStocks();
		model.addAttribute("indexStocks", stocks);

		logger.debug("Exiting StockDataController.displayHomePage()");
		return "jsp/home";
	}

	@GetMapping("/loadStockForm")
	public String displayStockForm(Model model) {
		logger.debug("Entering StockDataController.displayStockForm()");

		List<Stock> stocks = stockService.fetchAllStocks();
		model.addAttribute("indexStocks", stocks);

		logger.debug("Exiting StockDataController.displayStockForm()");
		return "jsp/stockForm";
	}


	@GetMapping("/getStockDetails")
	public String getStockDetailsForQuarter(@RequestParam String quarter, @RequestParam String companyId, Model model) {

		logger.debug("Entering StockDataController.getStockDetailsForQuarter()");

		List<StockData> stocks = null;
		Stock stock = null;
		if(companyId.equals("0"))
			stocks = stockDataService.fetchAllDataForQuarter(Integer.valueOf(quarter));
		else
			stocks = stockDataService.fetchStockDataForQuarter(Integer.valueOf(quarter), Integer.valueOf(companyId));
		model.addAttribute("stockList", stocks);
		logger.debug("Exiting StockDataController.getStockDetailsForQuarter()");
		return "jsp/stockDetails";
	}


	@RequestMapping(value = "/saveStockData", method = RequestMethod.POST)
	public String saveStockData(@ModelAttribute("stockData") StockData stockData, 
			BindingResult result, Model model) {

		logger.debug("Entering StockDataController.saveStockData()");

		try{
			stockDataService.insertStockData(stockData);    	
			List<Stock> stocks = stockService.fetchAllStocks();
			model.addAttribute("indexStocks", stocks);
			model.addAttribute("saveSuccessMsg", "Success");
		}catch(Exception ex) {
			System.out.print(ex.getMessage());
			logger.error(ex.getStackTrace());
			return "jsp/error";
		}

		logger.debug("Exiting StockDataController.saveStockData()");

		return "jsp/home"; 
	}


	@RequestMapping(value = "/bulkUpload", method = RequestMethod.POST , consumes = "multipart/form-data")
	public String saveBulkData(@RequestParam MultipartFile dataFile, Model model) {    	

		logger.debug("Entering StockDataController.saveBulkData()");

		try {
			stockDataService.uploadBulkData(dataFile);

			List<Stock> stocks = stockService.fetchAllStocks();
			model.addAttribute("indexStocks", stocks);
			model.addAttribute("saveSuccessMsg", "Success");
		}catch(Exception ex) {
			System.out.print(ex.getMessage());
			logger.error(ex.getStackTrace());
			return "jsp/error"; 
		}

		logger.debug("Exiting StockDataController.saveStockData()");

		return "jsp/home";
	}

}
