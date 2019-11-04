package com.lastminute.pricing.calculator;

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

	@Override
	public OrderVO run(OrderVO order) {
		for (CommerceItemVO ci : order.getCommerceItems()) {
			ci.setListPrice(ci.getsku().getListPrice());
			ci.setTotalBasePrice(ci.getQuantity() * ci.getListPrice());
		}
		return order;
	}

}
