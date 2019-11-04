package com.lastminute.VO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * POJO to represent the information of the order
 * 
 * @author Manuel Moranchel
 *
 */
public class OrderVO {

	/** Unique identifier */
	private String id;

	/** List of items in the order */
	List<CommerceItemVO> commerceItems;

	/** Total taxes applied to the order */
	private double totalTaxAmount;

	/** Total price before taxes */
	private double totalBasePrice;

	/** Total price after taxes */
	private double totalPrice;

	public OrderVO(String id, List<CommerceItemVO> commerceItems, double totalTaxAmount, double totalBasePrice,
			double totalPrice) {
		super();
		this.id = id;
		if (commerceItems != null && !commerceItems.isEmpty()) {
			this.commerceItems = commerceItems;
		} else {
			this.commerceItems = new ArrayList<CommerceItemVO>();
		}
		this.totalTaxAmount = totalTaxAmount;
		this.totalBasePrice = totalBasePrice;
		this.totalPrice = totalPrice;
	}

	public OrderVO() {
		super();
		this.id = UUID.randomUUID().toString();
		this.commerceItems = new ArrayList<CommerceItemVO>();
		this.totalTaxAmount = 0.0;
		this.totalBasePrice = 0.0;
		this.totalPrice = 0.0;
	}

	/**
	 * Returns a printable version of the order
	 * 
	 * @return the invoice
	 */
	public String printableInvoice() {
		StringBuffer invoiceOrder = new StringBuffer();
		for (CommerceItemVO ci : getCommerceItems()) {
			invoiceOrder.append(ci.printableInvoice() + "\n");
		}
		invoiceOrder.append("Sales Taxes: ");
		invoiceOrder.append(getTotalTaxAmount() + "\n");
		invoiceOrder.append("Total: ");
		invoiceOrder.append(getTotalPrice());
		return invoiceOrder.toString();
	}

	public boolean add(CommerceItemVO commerceItem) {
		return commerceItems.add(commerceItem);
	}

	public boolean addAll(Collection<? extends CommerceItemVO> commerceItem) {
		return commerceItems.addAll(commerceItem);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CommerceItemVO> getCommerceItems() {
		return commerceItems;
	}

	public void setCommerceItems(List<CommerceItemVO> commerceItems) {
		this.commerceItems = commerceItems;
	}

	public double getTotalTaxAmount() {
		return totalTaxAmount;
	}

	public void setTotalTaxAmount(double taxPercentage) {
		this.totalTaxAmount = taxPercentage;
	}

	public double getTotalBasePrice() {
		return totalBasePrice;
	}

	public void setTotalBasePrice(double totalBasePrice) {
		this.totalBasePrice = totalBasePrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalTaxPrice) {
		this.totalPrice = totalTaxPrice;
	}

	@Override
	public String toString() {
		return "OrderVO [id=" + id + ", commerceItems=" + commerceItems + ", taxPercentage=" + totalTaxAmount
				+ ", totalBasePrice=" + totalBasePrice + ", totalTaxPrice=" + totalPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commerceItems == null) ? 0 : commerceItems.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalTaxAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalBasePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderVO other = (OrderVO) obj;
		if (commerceItems == null) {
			if (other.commerceItems != null)
				return false;
		} else if (!commerceItems.equals(other.commerceItems))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(totalTaxAmount) != Double.doubleToLongBits(other.totalTaxAmount))
			return false;
		if (Double.doubleToLongBits(totalBasePrice) != Double.doubleToLongBits(other.totalBasePrice))
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		return true;
	}
}
