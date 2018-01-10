/**
 * 
 */
package com.n26.txnanalysis.dao.impl;

import org.springframework.stereotype.Repository;

import com.n26.txnanalysis.dao.TxnDao;
import com.n26.txnanalysis.domain.Transaction;

/**
 * @author abhinab
 *
 */
@Repository
public class TxnDaoImpl implements TxnDao {

	/* (non-Javadoc)
	 * @see com.n26.txnanalysis.dao.TxnDao#save(com.n26.txnanalysis.domain.Transaction)
	 */
	@Override
	public void save(Transaction transaction) {
		
	}

}
