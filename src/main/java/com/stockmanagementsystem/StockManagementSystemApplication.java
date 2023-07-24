package com.stockmanagementsystem;



import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class StockManagementSystemApplication{
	public static void main(String[] args) {
		SpringApplication.run(StockManagementSystemApplication.class, args);
	}

}
