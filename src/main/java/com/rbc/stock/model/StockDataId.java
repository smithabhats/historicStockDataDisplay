package com.rbc.stock.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class StockDataId  implements Serializable {


	private static final long serialVersionUID = 1L;

	private int stock_id;

    private Date trading_date;

    public StockDataId() {
    	
    }

    public StockDataId(int stock_id, Date trading_date) {
        this.stock_id = stock_id;
        this.trading_date = trading_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockDataId stockDataId = (StockDataId) o;
        return (stock_id == stockDataId.stock_id && trading_date.equals(stockDataId.trading_date));
    }

    @Override
    public int hashCode() {
        return Objects.hash(stock_id, trading_date);
    }
}