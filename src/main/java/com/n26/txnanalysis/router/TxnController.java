/**
 * 
 */
package com.n26.txnanalysis.router;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.txnanalysis.domain.Transaction;

/**
 * @author abhinab
 *
 */
@RestController
public class TxnController {

	@PostMapping(value = "transactions")
	public int postTransactions(@RequestBody @Valid Transaction transaction) {
		return HttpStatus.CREATED.value();
	}

}
