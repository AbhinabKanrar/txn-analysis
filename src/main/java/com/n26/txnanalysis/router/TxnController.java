/**
 * 
 */
package com.n26.txnanalysis.router;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.txnanalysis.domain.Statistics;
import com.n26.txnanalysis.domain.Transaction;
import com.n26.txnanalysis.service.TxnService;
import com.n26.txnanalysis.util.CommonConstant;

/**
 * @author abhinab
 *
 */
@RestController
public class TxnController {

	@Autowired
	private TxnService txnService;

	@PostMapping("transactions")
	public @ResponseBody ResponseEntity<String> postTransactions(@RequestBody @Valid Transaction transaction) {
		if (System.currentTimeMillis() - transaction.getTimestamp() > CommonConstant.ALLOWED_TIME_SPAN_IN_MIL) {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
		txnService.save(transaction);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@GetMapping("statistics")
	public Statistics getStatistics() {
		return txnService.fetchCurrentStatistics();
	}

}
