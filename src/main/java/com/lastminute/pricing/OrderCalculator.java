package com.lastminute.pricing;

import java.util.List;

import com.lastminute.VO.OrderVO;
import com.lastminute.pricing.calculator.Calculator;

/**
 * Main Class to calculate Order prices. It will implement a chain of
 * responsibility pattern to delegate calculations to the appropriate class.
 * 
 * @author Manuel Moranchel
 *
 */
public class OrderCalculator {

	/** List of calculators */
	private List<Calculator> calculators;

	/**
	 * Main loop to execute the configured calculators
	 * 
	 * @param order The order before its calculations
	 * @return The order POJO after applying the logic on the calculators
	 */
	public OrderVO calculateOrderPrice(OrderVO order) {
		
		try {
			for (Calculator calculator : calculators) {
				calculator.run(order);
			}
			return order;

		} catch (Exception e) {
			// TODO MM to use logger
			System.out.println(e);
		}
		return null;
	}

	public List<Calculator> getCalculators() {
		return calculators;
	}

	public void setCalculators(List<Calculator> calculators) {
		this.calculators = calculators;
	}
}
