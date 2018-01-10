/**
 * 
 */
package com.n26.txnanalysis.service;

import com.n26.txnanalysis.domain.Statistics;
import com.n26.txnanalysis.domain.Transaction;

/**
 * @author abhinab
 *
 */
public interface TxnService {

	/**
	 * Save current transaction
	 * 
	 * @param transaction
	 */
	void save(Transaction transaction);

	/**
	 * 
	 * Generate last 60 seconds statistics
	 * 
	 */
	void calculateStatistics();

	/**
	 * 
	 * Fetch last 60 seconds statistic details
	 * 
	 * @return com.n26.txnanalysis.domain.Statistics
	 */
	Statistics fetchCurrentStatistics();

}
