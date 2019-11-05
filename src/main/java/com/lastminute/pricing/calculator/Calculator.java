package com.lastminute.pricing.calculator;

import com.lastminute.VO.OrderVO;

/**
 * Interface to define the calculators interaction.
 * 
 * @author Manuel Moranchel
 *
 */
public interface Calculator {

	/**
	 * Perform the required functionality over the order, populate its data
	 * 
	 * @return
	 */
	public OrderVO run(OrderVO order);

}
