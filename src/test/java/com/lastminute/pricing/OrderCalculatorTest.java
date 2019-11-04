package com.lastminute.pricing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.lastminute.VO.CommerceItemVO;
import com.lastminute.VO.OrderVO;
import com.lastminute.VO.SkuVO;
import com.lastminute.VO.SkuVO.Type;

public class OrderCalculatorTest extends OrderCalculator {

	@Test
	public void testInput1() {
		SkuVO sku = new SkuVO("skuId", "book", 12.49, false, Type.BOOKS);
		CommerceItemVO ci = new CommerceItemVO("ciId", sku, 1, 0, 0, 0, 0);

		SkuVO sku1 = new SkuVO("skuId1", "CD", 14.99, false, Type.OTHER);
		CommerceItemVO ci1 = new CommerceItemVO("ciId2", sku1, 1, 0, 0, 0, 0);

		SkuVO sku2 = new SkuVO("skuId2", "Chocolate bar", 0.85, false, Type.FOOD);
		CommerceItemVO ci2 = new CommerceItemVO("ciId3", sku2, 1, 0, 0, 0, 0);

		OrderVO order = new OrderVO("orderId", Lists.newArrayList(ci, ci1, ci2), 0.0, 0.0, 0.0);

		calculateOrderPrice(order);

		assertTrue(order.getTotalTaxAmount() == 1.5);
		assertTrue(order.getTotalPrice() == 29.85);

	}

	@Test
	public void testInput2() {
		SkuVO sku = new SkuVO("skuId", "box of chocolates", 10, true, Type.OTHER);
		CommerceItemVO ci = new CommerceItemVO("ciId", sku, 1, 0, 0, 0, 0);

		SkuVO sku1 = new SkuVO("skuId1", "bottle of perfume", 47.5, true, Type.OTHER);
		CommerceItemVO ci1 = new CommerceItemVO("ciId2", sku1, 1, 0, 0, 0, 0);

		OrderVO order = new OrderVO("orderId", Lists.newArrayList(ci, ci1), 0.0, 0.0, 0.0);

		calculateOrderPrice(order);

		assertTrue(order.getTotalTaxAmount() == 8.65);
		assertTrue(order.getTotalPrice() == 66.15);
		
	}

	@Test
	public void testInput3() {
		SkuVO sku = new SkuVO("skuId", "bottle of perfume", 27.99, true, Type.BOOKS);
		CommerceItemVO ci = new CommerceItemVO("ciId", sku, 1, 0, 0, 0, 0);

		SkuVO sku1 = new SkuVO("skuId1", "bottle of perfume", 18.99, false, Type.OTHER);
		CommerceItemVO ci1 = new CommerceItemVO("ciId1", sku1, 1, 0, 0, 0, 0);

		SkuVO sku2 = new SkuVO("skuId2", "Headache pills", 9.75, false, Type.MEDICAL);
		CommerceItemVO ci2 = new CommerceItemVO("ciId2", sku2, 1, 0, 0, 0, 0);

		SkuVO sku3 = new SkuVO("skuId3", "chocolates", 11.25, true, Type.OTHER);
		CommerceItemVO ci3 = new CommerceItemVO("ciId3", sku3, 1, 0, 0, 0, 0);

		OrderVO order = new OrderVO("orderId", Lists.newArrayList(ci, ci1, ci2, ci3), 0.0, 0.0, 0.0);

		calculateOrderPrice(order);
		assertTrue(order.getTotalTaxAmount() == 5.0);
		assertTrue(order.getTotalPrice() == 73.0);
		
	}

}
