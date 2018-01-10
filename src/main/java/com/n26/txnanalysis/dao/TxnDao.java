/**
 * 
 */
package com.n26.txnanalysis.dao;

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
	 */
	void save(Transaction transaction);
	
}
