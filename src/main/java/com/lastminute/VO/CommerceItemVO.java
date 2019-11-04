package com.lastminute.VO;

import java.util.UUID;

/**
 * Representation of the Commerce Item added to the cart
 * 
 * @author Manuel Moranchel
 *
 */
public class CommerceItemVO {

	/** Unique identifier */
	private String id;

	/** Sku for the Commerce Item */
	private SkuVO sku;

	/** Quantity */
	private int quantity;

	/**
	 * List Price. Please note it is important to keep this information. The Sku
	 * price can change after the order is completed
	 */
	private double listPrice;

	/** Tax Price */
	private double taxAmount;

	/** Total price for all the items of this commerce item before taxes */
	private double totalBasePrice;

	/** Total price for all the items of this commerce item after taxes */
	private double totalPrice;

	public CommerceItemVO(String id, SkuVO sku, int quantity, double listPrice, double taxAmount, double totalBasePrice,
			double totalPrice) {
		super();
		this.id = id;
		this.sku = sku;
		this.quantity = quantity;
		this.listPrice = listPrice;
		this.taxAmount = taxAmount;
		this.totalBasePrice = totalBasePrice;
		this.totalPrice = totalPrice;
	}

	public CommerceItemVO() {
		super();
		this.id = UUID.randomUUID().toString();
		this.sku = null;
		this.quantity = 0;
		this.listPrice = 0.0;
		this.taxAmount = 0.0;
		this.totalBasePrice = 0.0;
		this.totalPrice = 0.0;
	}

	/**
	 * Returns a printable version of the CommerceItem
	 * 
	 * @return the invoice
	 */
	public String printableInvoice() {
		StringBuffer invoiceCi = new StringBuffer();
		invoiceCi.append(quantity);
		invoiceCi.append(" ");
		if (getsku().isImported()) {
			invoiceCi.append("Imported ");
		}
		invoiceCi.append(getsku().getProductName());
		invoiceCi.append(": ");
		invoiceCi.append(getTotalPrice());
		return invoiceCi.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SkuVO getsku() {
		return sku;
	}

	public void setsku(SkuVO sku) {
		this.sku = sku;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxPrice) {
		this.taxAmount = taxPrice;
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

	public void setTotalPrice(double totalTaxAmount) {
		this.totalPrice = totalTaxAmount;
	}

	@Override
	public String toString() {
		return "CommerceItemVO [id=" + id + ", sku=" + sku + ", quantity=" + quantity + ", listPrice=" + listPrice
				+ ", taxAmmount=" + taxAmount + ", totalBasePrice=" + totalBasePrice + ", totalTaxAmount=" + totalPrice
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(listPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		temp = Double.doubleToLongBits(taxAmount);
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
		CommerceItemVO other = (CommerceItemVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(listPrice) != Double.doubleToLongBits(other.listPrice))
			return false;
		if (quantity != other.quantity)
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (Double.doubleToLongBits(taxAmount) != Double.doubleToLongBits(other.taxAmount))
			return false;
		if (Double.doubleToLongBits(totalBasePrice) != Double.doubleToLongBits(other.totalBasePrice))
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		return true;
	}

}
