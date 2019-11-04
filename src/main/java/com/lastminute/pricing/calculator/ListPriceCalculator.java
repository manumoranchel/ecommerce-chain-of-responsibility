package com.lastminute.pricing.calculator;

import com.lastminute.VO.CommerceItemVO;
import com.lastminute.VO.OrderVO;
import com.lastminute.pricing.CalculatorTools;

/**
 * Calculator to calculate the list price. Populates the List prices in the
 * Commerce Items
 * 
 * @author Manuel Moranchel
 *
 */
public class ListPriceCalculator implements Calculator {

	@Override
	public OrderVO run(OrderVO order) {
		for (CommerceItemVO ci : order.getCommerceItems()) {
			ci.setListPrice(CalculatorTools.roundPrice(ci.getsku().getListPrice()));
			ci.setTotalBasePrice(CalculatorTools.roundPrice(ci.getQuantity() * ci.getListPrice()));
		}
		return order;
	}

}
