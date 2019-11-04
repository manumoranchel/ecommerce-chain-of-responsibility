package com.lastminute.pricing.calculator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.lastminute.VO.CommerceItemVO;
import com.lastminute.VO.OrderVO;
import com.lastminute.VO.SkuVO;
import com.lastminute.VO.SkuVO.Type;

public class ImportedCalculatorTest extends ImportedCalculator {

	@Test
	public void testRun() {
		SkuVO sku = new SkuVO("skuId", "SkuName", 10.99, true, Type.BOOKS);
		CommerceItemVO ci = new CommerceItemVO("ciId", sku, 1, 10.99, 0, 0, 0);
		
		SkuVO sku1 = new SkuVO("skuId1", "SkuName1", 1.00, true, Type.OTHER);
		CommerceItemVO ci1 = new CommerceItemVO("ciId", sku1, 2, 1.00, 0, 0, 0);
		
		OrderVO order = new OrderVO("orderId", Lists.newArrayList(ci,ci1), 0.0, 0.0, 0.0);
		
		order = run(order);
		assertTrue(ci.getTaxAmount() == 0.55);
		assertTrue(ci1.getTaxAmount() == 0.05);
		
		assertTrue(ci.getTotalTaxAmount() == 0.55);
		assertTrue(ci1.getTotalTaxAmount() == 0.1);
		
		
	}

	@Test
	public void testTaxedPriceScenario() {
		SkuVO sku = new SkuVO("skuId", "SkuName", 10.99, true, Type.BOOKS);
		CommerceItemVO ci = new CommerceItemVO("ciId", sku, 1, 10.99, 0, 0, 0);
		assertTrue(importedTax(ci) == 0.5495);

		sku.setListPrice(1.00);
		assertTrue(importedTax(ci) == 0.05);
	}

	@Test
	public void testCommerceItemImported() {
		SkuVO sku = new SkuVO("skuId", "SkuName", 10.99, false, Type.BOOKS);
		assertFalse(isCommerceItemImported(sku));

		sku.setImported(true);
		assertTrue(isCommerceItemImported(sku));
	}

}
