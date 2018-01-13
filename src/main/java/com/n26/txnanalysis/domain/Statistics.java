/**
 * 
 */
package com.n26.txnanalysis.domain;

import lombok.Data;

/**
 * @author abhinab
 *
 */
@Data
public class Statistics {

	private double sum = 0;
	private double avg = 0;
	private double max = 0;
	private double min = 0;
	private double count = 0;

}
