package com.lastminute.pricing.calculator;

import java.util.logging.Level;
import java.util.logging.Logger;

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
	
	static Logger logger = Logger.getLogger(TotalsCalculator.class.getName());

	@Override
	public OrderVO run(OrderVO order) {
		
		if (logger.isLoggable(Level.FINE)) {
			logger.log(Level.FINE, "Before calculating totals for order: " + order);
		}
		
		for (CommerceItemVO ci : order.getCommerceItems()) {
			// Addition of already rounded values to the nearest 0.05 don't required
			// re-round them. However this strategy might change over time hence adding the
			// call to the round method
			order.setTotalBasePrice(CalculatorTools.roundPrice(order.getTotalBasePrice() + ci.getTotalBasePrice()));
			order.setTotalTaxAmount(CalculatorTools.roundPrice(order.getTotalTaxAmount() + ci.getTaxAmount()));
			order.setTotalPrice(CalculatorTools.roundPrice(order.getTotalPrice() + ci.getTotalPrice()));
		}
		
		if (logger.isLoggable(Level.FINE)) {
			logger.log(Level.FINE, "After calculating totals for order: " + order);
		}
		
		return order;
	}

}
