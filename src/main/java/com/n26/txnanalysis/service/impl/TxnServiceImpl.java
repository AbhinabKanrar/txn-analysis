/**
 * 
 */
package com.n26.txnanalysis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n26.txnanalysis.dao.TxnDao;
import com.n26.txnanalysis.domain.Transaction;
import com.n26.txnanalysis.service.TxnService;

/**
 * @author abhinab
 *
 */
@Service
public class TxnServiceImpl implements TxnService {
	
	@Autowired
	private TxnDao txnDao;

	/* (non-Javadoc)
	 * @see com.n26.txnanalysis.service.TxnService#save(com.n26.txnanalysis.domain.Transaction)
	 */
	@Override
	public void save(Transaction transaction) {
		
	}

}
