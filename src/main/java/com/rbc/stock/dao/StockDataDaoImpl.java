package com.rbc.stock.dao;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rbc.stock.controller.StockDataController;

@Service
public class StockDataDaoImpl implements StockDataDao {

	Logger logger = Logger.getLogger(StockDataController.class);

	@Override
	public boolean uploadBulkData(MultipartFile dataFile) {
		logger.debug("Entering StockDataDaoImpl.uploadBulkData()");

		Connection con = null;
		Reader fileReader = null;

		try {

			System.out.println("Loading driver");
			Class.forName("org.postgresql.Driver");

			System.out.println("Connecting to DB");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RBCstock","postgres","admin");

			System.out.println("Copying text data rows from stdin");

			CopyManager copyManager = new CopyManager((BaseConnection) con);

			//fileReader = new FileReader(url); //"C:\\Users\\girij\\Summi\\RBC\\data\\dow_jones_index_data.csv");
			fileReader = new InputStreamReader(dataFile.getInputStream());
			copyManager.copyIn("COPY stock_data FROM STDIN DELIMITER ',' CSV HEADER", fileReader );

			System.out.println("Done");

		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			logger.error(ex.getStackTrace());
			return false;
		}
		finally {
			try {
				if(fileReader != null)
					fileReader.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				logger.error(e.getStackTrace());
			}
		}
		logger.debug("Exiting StockDataDaoImpl.uploadBulkData()");

		return true;
	}

}
