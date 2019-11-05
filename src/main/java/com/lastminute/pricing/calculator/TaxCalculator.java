package com.lastminute.pricing.calculator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.lastminute.Constants;
import com.lastminute.VO.CommerceItemVO;
import com.lastminute.VO.OrderVO;
import com.lastminute.VO.SkuVO;
import com.lastminute.VO.SkuVO.Type;
import com.lastminute.pricing.CalculatorTools;

/**
 * Calculator to calculate the taxes
 * 
 * @author Manuel Moranchel
 *
 */
public class TaxCalculator implements Calculator{
	
	static Logger logger = Logger.getLogger(TaxCalculator.class.getName());

	@Override
	public OrderVO run(OrderVO order) {
		
		if (logger.isLoggable(Level.FINE)) {
			logger.log(Level.FINE, "Before calculating taxes for order: " + order);
		}
		
		for (CommerceItemVO commerceItem : order.getCommerceItems()) {
			if (applytaxes(commerceItem.getsku())) {
				commerceItem.setTaxAmount(CalculatorTools.roundPrice(commerceItem.getQuantity() * (commerceItem.getTaxAmount() + taxedPrice(commerceItem))));
			}
			commerceItem.setTotalPrice(CalculatorTools.roundPrice(commerceItem.getTotalBasePrice() + commerceItem.getTaxAmount()));
		}
		
		if (logger.isLoggable(Level.FINE)) {
			logger.log(Level.FINE, "After calculating taxes for order: " + order);
		}
		
		return order;
	}

	/**
	 * Calculate the tax for products
	 * @param commerceItem
	 * @return
	 */
	protected double taxedPrice(CommerceItemVO commerceItem) {
		return commerceItem.getsku().getListPrice() * Constants.TAX_PERCENTAGE;
	}
	
	/**
	 * Determine whether we need to apply taxes
	 * @param sku
	 * @return
	 */
	protected boolean applytaxes(SkuVO sku) {
		return sku.getSkuType() == Type.OTHER;
	}

}
