package com.rbc.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rbc.stock")
public class RbcStockAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbcStockAppApplication.class, args);
		
		System.out.print("\n\nApp running\n\n");
	}

}
