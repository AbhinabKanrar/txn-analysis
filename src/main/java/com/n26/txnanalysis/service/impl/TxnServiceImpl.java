/**
 * 
 */
package com.n26.txnanalysis.service.impl;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n26.txnanalysis.dao.TxnDao;
import com.n26.txnanalysis.domain.Statistics;
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

	private static Statistics statistics = new Statistics();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.n26.txnanalysis.service.TxnService#save(com.n26.txnanalysis.domain.
	 * Transaction)
	 */
	@Override
	public void save(Transaction transaction) {
		txnDao.save(transaction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.n26.txnanalysis.service.TxnService#calculateStatistics()
	 */
	@Override
	public void calculateStatistics() {
		Map<Integer, Transaction> txnHolder = txnDao.fetchTransactions();
		statistics = new Statistics();
		if (txnHolder != null && !txnHolder.isEmpty()) {
			Supplier<DoubleStream> txnAmountStreamSupplier = () -> txnHolder.values().stream()
					.map(txn -> txn.getAmount()).mapToDouble(Double::doubleValue);
			statistics.setSum(txnAmountStreamSupplier.get().sum());
			statistics.setAvg(statistics.getSum() / txnHolder.size());
			statistics.setMax(txnAmountStreamSupplier.get().max().getAsDouble());
			statistics.setMin(txnAmountStreamSupplier.get().min().getAsDouble());
			statistics.setCount(txnHolder.size());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.n26.txnanalysis.service.TxnService#fetchCurrentStatistics()
	 */
	@Override
	public Statistics fetchCurrentStatistics() {
		return statistics;
	}

}
