/**
 * 
 */
package com.n26.txnanalysis.dao;

import java.util.Map;

import com.n26.txnanalysis.domain.Transaction;

/**
 * @author abhinab
 *
 */
public interface TxnDao {

	/**
	 * Save current transaction into in-memory hashmap
	 * 
	 * @param transaction
	 * @return transaction
	 */
	Transaction save(Transaction transaction);
	
	/**
	 * Fetch last 60 seconds statistics
	 * 
	 * @return Map<Integer, Transaction>
	 */
	Map<Integer, Transaction> fetchTransactions();
	
}
