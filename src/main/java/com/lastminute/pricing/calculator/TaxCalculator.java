package com.lastminute.pricing.calculator;

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

	@Override
	public OrderVO run(OrderVO order) {
		for (CommerceItemVO ci : order.getCommerceItems()) {
			if (applytaxes(ci.getsku())) {
				ci.setTaxAmount(CalculatorTools.roundPrice(ci.getQuantity() * (ci.getTaxAmount() + taxedPrice(ci))));
			}
			ci.setTotalPrice(CalculatorTools.roundPrice(ci.getTotalBasePrice() + ci.getTaxAmount()));
		}
		return order;
	}

	/**
	 * Calculate the tax for products
	 * @param ci
	 * @return
	 */
	protected double taxedPrice(CommerceItemVO ci) {
		return ci.getsku().getListPrice() * Constants.TAX_PERCENTAGE;
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
