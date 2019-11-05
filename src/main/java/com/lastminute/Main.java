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
			SkuVO skuBook = new SkuVO("skuBook", "book", 12.49, false, Type.BOOKS);
			CommerceItemVO ciBook = new CommerceItemVO("ciBook", skuBook, 1, 0, 0, 0, 0);

			SkuVO skuCD = new SkuVO("skuCD", "CD", 14.99, false, Type.OTHER);
			CommerceItemVO ciCD = new CommerceItemVO("ciCD", skuCD, 1, 0, 0, 0, 0);

			SkuVO skuChocolate = new SkuVO("skuChocolate", "Chocolate bar", 0.85, false, Type.FOOD);
			CommerceItemVO ciChocolate = new CommerceItemVO("ciChocolate", skuChocolate, 1, 0, 0, 0, 0);

			OrderVO order = new OrderVO("orderId", Lists.newArrayList(ciBook, ciCD, ciChocolate), 0.0, 0.0, 0.0);

			orderCalculator.calculateOrderPrice(order);
			System.out.println("Output1:");
			System.out.println(order.printableInvoice());
			System.out.println();

		}

		public static void testInput2() {
			SkuVO skuChocolateBox = new SkuVO("skuChocolateBox", "box of chocolates", 10, true, Type.OTHER);
			CommerceItemVO ciChocolateBox = new CommerceItemVO("ciChocolateBox", skuChocolateBox, 1, 0, 0, 0, 0);

			SkuVO skuBottlePerfume = new SkuVO("skuBottlePerfume", "bottle of perfume", 47.5, true, Type.OTHER);
			CommerceItemVO ciBottlePerfume = new CommerceItemVO("ciBottlePerfume", skuBottlePerfume, 1, 0, 0, 0, 0);

			OrderVO order = new OrderVO("orderId", Lists.newArrayList(ciChocolateBox, ciBottlePerfume), 0.0, 0.0, 0.0);

			orderCalculator.calculateOrderPrice(order);
			System.out.println("Output2:");
			System.out.println(order.printableInvoice());
			System.out.println();

		}

		public static void testInput3() {
			SkuVO skuBottlePerfume = new SkuVO("skuBottlePerfume", "bottle of perfume", 27.99, true, Type.BOOKS);
			CommerceItemVO ciBottlePerfume = new CommerceItemVO("ciBottlePerfume", skuBottlePerfume, 1, 0, 0, 0, 0);

			SkuVO skuBottlePerfume1 = new SkuVO("skuBottlePerfume1", "bottle of perfume", 18.99, false, Type.OTHER);
			CommerceItemVO ciBottlePerfume1 = new CommerceItemVO("ciBottlePerfume1", skuBottlePerfume1, 1, 0, 0, 0, 0);

			SkuVO skuHeadachePills = new SkuVO("skuHeadachePills", "Headache pills", 9.75, false, Type.MEDICAL);
			CommerceItemVO ciHeadachePills = new CommerceItemVO("ciHeadachePills", skuHeadachePills, 1, 0, 0, 0, 0);

			SkuVO skuChocolate = new SkuVO("skuChocolate", "chocolates", 11.25, true, Type.OTHER);
			CommerceItemVO ciChocolateBox = new CommerceItemVO("ciChocolateBox", skuChocolate, 1, 0, 0, 0, 0);

			OrderVO order = new OrderVO("orderId", Lists.newArrayList(ciBottlePerfume, ciBottlePerfume1, ciHeadachePills, ciChocolateBox), 0.0, 0.0, 0.0);

			orderCalculator.calculateOrderPrice(order);
			System.out.println("Output3:");
			System.out.println(order.printableInvoice());

		}


}
