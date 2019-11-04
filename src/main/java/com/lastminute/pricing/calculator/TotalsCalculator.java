package com.lastminute.pricing.calculator;

import com.lastminute.VO.CommerceItemVO;
import com.lastminute.VO.OrderVO;
import com.lastminute.pricing.CalculatorTools;

/**
 * Calculator to calculate the totals in the Order
 * 
 * @author Manuel Moranchel
 *
 */
public class TotalsCalculator implements Calculator {

	@Override
	public OrderVO run(OrderVO order) {
		for (CommerceItemVO ci : order.getCommerceItems()) {
			// Addition of already rounded values to the nearest 0.05 don't required
			// re-round them. However this strategy might change over time hence adding the
			// call to the round method
			order.setTotalBasePrice(CalculatorTools.roundPrice(order.getTotalBasePrice() + ci.getTotalBasePrice()));
			order.setTotalTaxPrice(CalculatorTools.roundPrice(order.getTotalTaxPrice() + ci.getTotalTaxAmount()));
		}
		return order;
	}

}
