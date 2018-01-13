package com.n26.txnanalysis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.n26.txnanalysis.domain.Statistics;
import com.n26.txnanalysis.domain.Transaction;
import com.n26.txnanalysis.router.TxnController;

/**
 * @author abhinab
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TxnAnalysisApplicationTests {

	Transaction validTxn = new Transaction();
	Transaction inValidTxn = new Transaction();

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private TxnController txnController;

	@Before
	public void setUp() {
		validTxn.setAmount(100);
		validTxn.setTimestamp(Long.valueOf("1678192204000"));

		inValidTxn.setAmount(101);
		inValidTxn.setTimestamp(Long.valueOf("1478192204000"));
	}

	@Test
	public void contextLoads() {
		assertThat(txnController).isNotNull();
	}

	/**
	 * Test transaction API with valid input
	 */
	@Test
	public void postValidTransaction_checkHttpCode() {
		this.restTemplate.postForObject("http://localhost:" + port + "/transactions", validTxn, String.class);
	}

	/**
	 * Test transaction API with invalid input
	 */
	@Test
	public void postInValidTransaction_checkHttpCode() {
		this.restTemplate.postForObject("http://localhost:" + port + "/transactions", inValidTxn, String.class);
	}

	/**
	 * Test last sixty seconds statistics API
	 */
	@Test
	public void getLastSixtySecondsStatistics_checkContents() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/statistics", Statistics.class))
				.isNotNull();
	}

}
