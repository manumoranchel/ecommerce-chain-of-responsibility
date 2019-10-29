package com.lastminute.pricing.calculator;

import com.lastminute.VO.CommerceItemVO;
import com.lastminute.VO.OrderVO;

/**
 * Calculator to calculate the list price
 * 
 * @author Manuel Moranchel
 *
 */
public class ListPriceCalculator implements Calculator{

	@Override
	public OrderVO run(OrderVO order) {
		for (CommerceItemVO ci : order.getCommerceItems()) {
			ci.setListPrice(ci.getsku().getListPrice());
			ci.setTotalBasePrice(ci.getQuantity() * ci.getListPrice());
		}
		return order;
	}

}
