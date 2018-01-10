/**
 * 
 */
package com.n26.txnanalysis.service;

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
	
}
