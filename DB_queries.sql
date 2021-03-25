CREATE TABLE stocks(
	stock_id serial PRIMARY KEY,
	stock_name VARCHAR ( 50 ) NOT NULL,
	stock_code VARCHAR ( 255 ) UNIQUE NOT NULL
);

COPY stocks
FROM 'C:\data\stocks.csv' 
DELIMITER ',' 
CSV HEADER;

CREATE TABLE stock_data(
quarter	smallint,
stock_id smallint,	
trading_date	date,
open_price	NUMERIC(5,2),
highest NUMERIC(5,2),
lowest NUMERIC(5,2),
closing_price	NUMERIC(5,2),
volume  integer,
percent_change_price	NUMERIC(5,2),
days_to_next_dividend	smallint,
percent_return_next_dividend  NUMERIC(5,2),

PRIMARY KEY (stock_id, trading_date),
  FOREIGN KEY (stock_id)
      REFERENCES index_stocks(stock_id)
);
