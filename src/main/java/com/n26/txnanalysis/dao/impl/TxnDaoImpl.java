/**
 * 
 */
package com.n26.txnanalysis.dao.impl;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.PassiveExpiringMap;
import org.springframework.stereotype.Repository;

import com.n26.txnanalysis.dao.TxnDao;
import com.n26.txnanalysis.domain.Transaction;
import com.n26.txnanalysis.util.CommonConstant;

/**
 * @author abhinab
 *
 */
@Repository
public class TxnDaoImpl implements TxnDao {

	private static PassiveExpiringMap<Integer, Transaction> txnHolder = new PassiveExpiringMap<>(
			CommonConstant.ALLOWED_TIME_SPAN_IN_MIL, TimeUnit.MILLISECONDS);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.n26.txnanalysis.dao.TxnDao#save(com.n26.txnanalysis.domain.Transaction)
	 */
	@Override
	public Transaction save(Transaction transaction) {
		return txnHolder.put(ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE), transaction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.n26.txnanalysis.dao.TxnDao#fetchStatistics()
	 */
	@Override
	public Map<Integer, Transaction> fetchTransactions() {
		return txnHolder;
	}

}
