package com.lastminute.pricing.calculator;

import com.lastminute.Constants;
import com.lastminute.VO.CommerceItemVO;
import com.lastminute.VO.OrderVO;
import com.lastminute.VO.SkuVO;

/**
 * Calculator to add the imported price
 * 
 * @author Manuel Moranchel
 *
 */
public class ImportedCalculator implements Calculator {

	@Override
	public OrderVO run(OrderVO order) {
		for (CommerceItemVO ci : order.getCommerceItems()) {
			if (isCommerceItemImported(ci.getsku())) {
				ci.setTaxAmount(ci.getTaxAmount() + importedTax(ci));
				ci.setTotalTaxAmount(ci.getQuantity() * ci.getTaxAmount());
			}
		}
		return order;
	}

	/**
	 * Calculate the tax for imported products
	 * 
	 * @param ci
	 * @return
	 */
	private double importedTax(CommerceItemVO ci) {
		return ci.getsku().getListPrice() * Constants.IMPORTED_TAX_PERCENTAGE;
	}

	/**
	 * Determine whether the sku is imported
	 * 
	 * @param getsku
	 * @return true if it is imported
	 */
	private boolean isCommerceItemImported(SkuVO sku) {
		return sku.isImported();
	}

}
