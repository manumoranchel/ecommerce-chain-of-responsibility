package com.lastminute.VO;

import java.util.UUID;

/**
 * Representation of the Commerce Item added to the cart
 * 
 * @author Manuel Moranchel
 *
 */
public class CommerceItemVO {
	
	/** Unique identifier*/
	private String id;

	/** Sku for the Commerce Item*/
	private SkuVO sku;

	/** Quantity*/
	private int quantity;

	/** List Price. Please note it is important to keep this information. The Sku price can change after the order is completed*/
	private double listPrice;

	/** Tax Price */
	private double taxAmmount;

	/** Total price for all the items of this commerce item before taxes */
	private double totalBasePrice;

	/** Total price for all the items of this commerce item after taxes */
	private double totalTaxAmount;

	public CommerceItemVO(String id, SkuVO sku, int quantity, double listPrice, double taxAmount,
			double totalBasePrice, double totalTaxAmount) {
		super();
		this.id = id;
		this.sku = sku;
		this.quantity = quantity;
		this.listPrice = listPrice;
		this.taxAmmount = taxAmount;
		this.totalBasePrice = totalBasePrice;
		this.totalTaxAmount = totalTaxAmount;
	}

	public CommerceItemVO() {
		super();
		this.id = UUID.randomUUID().toString();
		this.sku = null;
		this.quantity = 0;
		this.listPrice = 0.0;
		this.taxAmmount = 0.0;
		this.totalBasePrice = 0.0;
		this.totalTaxAmount = 0.0;
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
		return taxAmmount;
	}

	public void setTaxAmount(double taxPrice) {
		this.taxAmmount = taxPrice;
	}

	public double getTotalBasePrice() {
		return totalBasePrice;
	}

	public void setTotalBasePrice(double totalBasePrice) {
		this.totalBasePrice = totalBasePrice;
	}

	public double getTotalTaxAmount() {
		return totalTaxAmount;
	}

	public void setTotalTaxAmount(double totalTaxAmount) {
		this.totalTaxAmount = totalTaxAmount;
	}

	@Override
	public String toString() {
		return "CommerceItemVO [id=" + id + ", sku=" + sku + ", quantity=" + quantity + ", listPrice=" + listPrice
				+ ", taxAmmount=" + taxAmmount + ", totalBasePrice=" + totalBasePrice + ", totalTaxAmount="
				+ totalTaxAmount + "]";
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
		temp = Double.doubleToLongBits(taxAmmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalBasePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalTaxAmount);
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
		if (Double.doubleToLongBits(taxAmmount) != Double.doubleToLongBits(other.taxAmmount))
			return false;
		if (Double.doubleToLongBits(totalBasePrice) != Double.doubleToLongBits(other.totalBasePrice))
			return false;
		if (Double.doubleToLongBits(totalTaxAmount) != Double.doubleToLongBits(other.totalTaxAmount))
			return false;
		return true;
	}

}
