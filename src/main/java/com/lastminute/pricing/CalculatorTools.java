package com.lastminute.pricing;

/**
 * Tool class to hold common utilities for calculation
 * 
 * @author Manuel Moranchel
 *
 */
public class CalculatorTools {

	/**
	 * Facade method for price rounding operations. The code will rely on this
	 * method. If rounding strategy needs to be changed, it can be done in one
	 * place.
	 * 
	 * @param price The not rounded price
	 * @return The price rounded
	 */
	public static double roundPrice(double price) {
		return roundToNearest005(price);
	}

	/**
	 * Round to the nearest 0.05
	 * 
	 * @param price The not rounded price
	 * @return The price rounded
	 */
	public static double roundToNearest005(double price) {
		return Math.round(price * 20) / 20.0;
	}
}
