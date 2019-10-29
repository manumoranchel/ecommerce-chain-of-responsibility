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
	private double taxPrice;

	/** Percentage of taxes */
	private double taxPercentage;

	/** Total price for all the items of this commerce item before taxes */
	private double totalBasePrice;

	/** Total price for all the items of this commerce item after taxes */
	private double totalTaxPrice;

	public CommerceItemVO(String id, SkuVO sku, int quantity, double listPrice, double taxPrice,
			double taxPercentage, double totalBasePrice, double totalTaxPrice) {
		super();
		this.id = id;
		this.sku = sku;
		this.quantity = quantity;
		this.listPrice = listPrice;
		this.taxPrice = taxPrice;
		this.taxPercentage = taxPercentage;
		this.totalBasePrice = totalBasePrice;
		this.totalTaxPrice = totalTaxPrice;
	}

	public CommerceItemVO() {
		super();
		this.id = UUID.randomUUID().toString();
		this.sku = null;
		this.quantity = 0;
		this.listPrice = 0.0;
		this.taxPrice = 0.0;
		this.taxPercentage = 0.0;
		this.totalBasePrice = 0.0;
		this.totalTaxPrice = 0.0;
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

	public double getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(double taxPrice) {
		this.taxPrice = taxPrice;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public double getTotalBasePrice() {
		return totalBasePrice;
	}

	public void setTotalBasePrice(double totalBasePrice) {
		this.totalBasePrice = totalBasePrice;
	}

	public double getTotalTaxPrice() {
		return totalTaxPrice;
	}

	public void setTotalTaxPrice(double totalTaxPrice) {
		this.totalTaxPrice = totalTaxPrice;
	}

	@Override
	public String toString() {
		return "CommerceItemVO [id=" + id + ", sku=" + sku + ", quantity=" + quantity + ", listPrice="
				+ listPrice + ", taxPrice=" + taxPrice + ", taxPercentage=" + taxPercentage + ", totalBasePrice="
				+ totalBasePrice + ", totalTaxPrice=" + totalTaxPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(listPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime * result + quantity;
		temp = Double.doubleToLongBits(taxPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalBasePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalTaxPrice);
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
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (quantity != other.quantity)
			return false;
		if (Double.doubleToLongBits(taxPercentage) != Double.doubleToLongBits(other.taxPercentage))
			return false;
		if (Double.doubleToLongBits(taxPrice) != Double.doubleToLongBits(other.taxPrice))
			return false;
		if (Double.doubleToLongBits(totalBasePrice) != Double.doubleToLongBits(other.totalBasePrice))
			return false;
		if (Double.doubleToLongBits(totalTaxPrice) != Double.doubleToLongBits(other.totalTaxPrice))
			return false;
		return true;
	}
}
