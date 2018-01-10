package com.n26.txnanalysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.n26.txnanalysis.service.TxnService;

/**
 * @author abhinab
 *
 */
@SpringBootApplication
public class TxnAnalysisApplication implements CommandLineRunner {

	@Autowired
	private TxnService txnService;
	
	public static void main(String[] args) {
		SpringApplication.run(TxnAnalysisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			txnService.calculateStatistics();
			Thread.sleep(1000);
		}
	}
	
}
