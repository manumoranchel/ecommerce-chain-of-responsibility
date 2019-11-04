package com.lastminute;

import com.google.common.collect.Lists;
import com.lastminute.VO.CommerceItemVO;
import com.lastminute.VO.OrderVO;
import com.lastminute.VO.SkuVO;
import com.lastminute.VO.SkuVO.Type;
import com.lastminute.pricing.OrderCalculator;

/**
 * Main class to execute the test required 
 * 
 * @author Manuel Moranchel
 *
 */
public class Main {
	
	static OrderCalculator orderCalculator;
	
	public static void main(String[] args) {
		orderCalculator = new OrderCalculator();
		testInput1();
		testInput2();
		testInput3();
	}
	
		public static void testInput1() {
			SkuVO sku = new SkuVO("skuId", "book", 12.49, false, Type.BOOKS);
			CommerceItemVO ci = new CommerceItemVO("ciId", sku, 1, 0, 0, 0, 0);

			SkuVO sku1 = new SkuVO("skuId1", "CD", 14.99, false, Type.OTHER);
			CommerceItemVO ci1 = new CommerceItemVO("ciId2", sku1, 1, 0, 0, 0, 0);

			SkuVO sku2 = new SkuVO("skuId2", "Chocolate bar", 0.85, false, Type.FOOD);
			CommerceItemVO ci2 = new CommerceItemVO("ciId3", sku2, 1, 0, 0, 0, 0);

			OrderVO order = new OrderVO("orderId", Lists.newArrayList(ci, ci1, ci2), 0.0, 0.0, 0.0);

			orderCalculator.calculateOrderPrice(order);
			System.out.println("Input 1:");
			System.out.println(order.printableInvoice());
			System.out.println();

		}

		public static void testInput2() {
			SkuVO sku = new SkuVO("skuId", "box of chocolates", 10, true, Type.OTHER);
			CommerceItemVO ci = new CommerceItemVO("ciId", sku, 1, 0, 0, 0, 0);

			SkuVO sku1 = new SkuVO("skuId1", "bottle of perfume", 47.5, true, Type.OTHER);
			CommerceItemVO ci1 = new CommerceItemVO("ciId2", sku1, 1, 0, 0, 0, 0);

			OrderVO order = new OrderVO("orderId", Lists.newArrayList(ci, ci1), 0.0, 0.0, 0.0);

			orderCalculator.calculateOrderPrice(order);
			System.out.println("Input 2:");
			System.out.println(order.printableInvoice());
			System.out.println();

		}

		public static void testInput3() {
			SkuVO sku = new SkuVO("skuId", "bottle of perfume", 27.99, true, Type.BOOKS);
			CommerceItemVO ci = new CommerceItemVO("ciId", sku, 1, 0, 0, 0, 0);

			SkuVO sku1 = new SkuVO("skuId1", "bottle of perfume", 18.99, false, Type.OTHER);
			CommerceItemVO ci1 = new CommerceItemVO("ciId1", sku1, 1, 0, 0, 0, 0);

			SkuVO sku2 = new SkuVO("skuId2", "Headache pills", 9.75, false, Type.MEDICAL);
			CommerceItemVO ci2 = new CommerceItemVO("ciId2", sku2, 1, 0, 0, 0, 0);

			SkuVO sku3 = new SkuVO("skuId3", "chocolates", 11.25, true, Type.OTHER);
			CommerceItemVO ci3 = new CommerceItemVO("ciId3", sku3, 1, 0, 0, 0, 0);

			OrderVO order = new OrderVO("orderId", Lists.newArrayList(ci, ci1, ci2, ci3), 0.0, 0.0, 0.0);

			orderCalculator.calculateOrderPrice(order);
			System.out.println("Input 3:");
			System.out.println(order.printableInvoice());

		}


}
