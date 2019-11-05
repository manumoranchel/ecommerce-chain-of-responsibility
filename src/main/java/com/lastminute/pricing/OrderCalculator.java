package com.lastminute.pricing;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.common.collect.Lists;
import com.lastminute.VO.OrderVO;
import com.lastminute.pricing.calculator.Calculator;
import com.lastminute.pricing.calculator.ImportedCalculator;
import com.lastminute.pricing.calculator.ListPriceCalculator;
import com.lastminute.pricing.calculator.TaxCalculator;
import com.lastminute.pricing.calculator.TotalsCalculator;

/**
 * Main Class to calculate Order prices. It will implement a chain of
 * responsibility pattern to delegate calculations to the appropriate class.
 * 
 * @author Manuel Moranchel
 *
 */
public class OrderCalculator {

	static Logger logger = Logger.getLogger(OrderCalculator.class.getName());

	/** List of calculators */
	private List<Calculator> calculators;

	// Static Block to init the calculators on component startup
	{
		initCalculators();
	}

	/**
	 * Init the calculators. Typically this configuration will take place in a
	 * component configuration
	 */
	protected void initCalculators() {

		calculators = Lists.newArrayList(new ListPriceCalculator(), new TaxCalculator(), new ImportedCalculator(),
				new TotalsCalculator());

		logger.log(Level.INFO, "Setting up the configured calculators: ");
		calculators.forEach(name -> {
			logger.log(Level.INFO, name.getClass().getName());
		});

	}

	/**
	 * Main loop to execute the configured calculators
	 * 
	 * @param order The order before its calculations
	 * @return The order POJO after applying the logic on the calculators
	 */
	public OrderVO calculateOrderPrice(OrderVO order) {

		try {
			calculators.forEach(calculator -> {
				calculator.run(order);
			});
			return order;

		} catch (Exception e) {
			// TODO do not catch Exception, catch it's subclasses instead. 
			logger.log(Level.SEVERE, "Problem executing the price calculation", e);
		}
		return null;
	}

	public List<Calculator> getCalculators() {
		// Added resilience to the code to ensure the list of calculators is initialised
		if (calculators == null || calculators.isEmpty()) {
			initCalculators();
		}
		return calculators;
	}

	public void setCalculators(List<Calculator> calculators) {
		this.calculators = calculators;
	}
}
