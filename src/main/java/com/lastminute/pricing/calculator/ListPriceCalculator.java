package com.lastminute.pricing.calculator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.lastminute.VO.CommerceItemVO;
import com.lastminute.VO.OrderVO;

/**
 * Calculator to calculate the list price. Populates the List prices in the
 * Commerce Items
 * 
 * @author Manuel Moranchel
 *
 */
public class ListPriceCalculator implements Calculator {
	
	static Logger logger = Logger.getLogger(ImportedCalculator.class.getName());

	@Override
	public OrderVO run(OrderVO order) {
		
		if (logger.isLoggable(Level.FINE)) {
			logger.log(Level.FINE, "Before calculating list price for order: " + order);
		}
		
		for (CommerceItemVO commerceitem : order.getCommerceItems()) {
			commerceitem.setListPrice(commerceitem.getsku().getListPrice());
			commerceitem.setTotalBasePrice(commerceitem.getQuantity() * commerceitem.getListPrice());
		}
		
		if (logger.isLoggable(Level.FINE)) {
			logger.log(Level.FINE, "After calculating list price for order: " + order);
		}
		
		return order;
	}

}
