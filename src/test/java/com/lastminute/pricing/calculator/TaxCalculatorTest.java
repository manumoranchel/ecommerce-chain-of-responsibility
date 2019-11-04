package com.lastminute.pricing.calculator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.lastminute.VO.CommerceItemVO;
import com.lastminute.VO.OrderVO;
import com.lastminute.VO.SkuVO;
import com.lastminute.VO.SkuVO.Type;

public class TaxCalculatorTest extends TaxCalculator {

	@Test
	public void testRun() {
		SkuVO sku = new SkuVO("skuId", "SkuName", 10.99, true, Type.BOOKS);
		CommerceItemVO ci = new CommerceItemVO("ciId", sku, 1, 10.99, 0, 0, 0);
		
		SkuVO sku1 = new SkuVO("skuId1", "SkuName1", 1.00, true, Type.OTHER);
		CommerceItemVO ci1 = new CommerceItemVO("ciId", sku1, 2, 1.00, 0, 0, 0);
		
		OrderVO order = new OrderVO("orderId", Lists.newArrayList(ci,ci1), 0.0, 0.0, 0.0);
		
		order = run(order);
		assertTrue(ci.getTaxAmount() == 0);
		assertTrue(ci1.getTaxAmount() == 0.1);
		
		assertTrue(ci.getTotalTaxAmount() == 0);
		assertTrue(ci1.getTotalTaxAmount() == 0.2);
		
		
	}

	@Test
	public void testTaxedPriceScenario() {
		SkuVO sku = new SkuVO("skuId", "SkuName", 10.99, true, Type.BOOKS);
		CommerceItemVO ci = new CommerceItemVO("ciId", sku, 1, 10.99, 0, 0, 0);
		assertTrue(taxedPrice(ci) == 1.099);

		sku.setListPrice(1.00);
		assertTrue(taxedPrice(ci) == 0.1);
	}

	@Test
	public void testApplytaxesScenario() {
		SkuVO sku = new SkuVO("skuId", "SkuName", 10.99, true, Type.BOOKS);
		assertFalse(applytaxes(sku));

		sku.setSkuType(Type.FOOD);
		assertFalse(applytaxes(sku));

		sku.setSkuType(Type.OTHER);
		assertTrue(applytaxes(sku));
	}

}
