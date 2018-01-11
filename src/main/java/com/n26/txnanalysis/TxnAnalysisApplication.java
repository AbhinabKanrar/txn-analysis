package com.n26.txnanalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author abhinab
 *
 */
@SpringBootApplication
@EnableScheduling
public class TxnAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TxnAnalysisApplication.class, args);
	}

}
