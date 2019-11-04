package com.lastminute.pricing.calculator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.lastminute.VO.CommerceItemVO;
import com.lastminute.VO.OrderVO;
import com.lastminute.VO.SkuVO;
import com.lastminute.VO.SkuVO.Type;

public class ListPriceCalculatorTest extends ListPriceCalculator{

	@Test
	public void run() {
		SkuVO sku = new SkuVO("skuId", "SkuName", 10.99, true, Type.BOOKS);
		CommerceItemVO ci = new CommerceItemVO("ciId", sku, 1, 0.0, 0, 0, 0);
		
		SkuVO sku1 = new SkuVO("skuId1", "SkuName1", 1.00, true, Type.OTHER);
		CommerceItemVO ci1 = new CommerceItemVO("ciId", sku1, 2, 0.00, 0, 0, 0);
		
		OrderVO order = new OrderVO("orderId", Lists.newArrayList(ci,ci1), 0.0, 0.0, 0.0);
		
		order = run(order);
		assertTrue(ci.getListPrice() != 0.0);
		assertTrue(ci.getTotalBasePrice() != 0.0);
		
		assertTrue(ci1.getListPrice() == 1.0);
		assertTrue(ci1.getTotalBasePrice() == 2.0);
	}

}
