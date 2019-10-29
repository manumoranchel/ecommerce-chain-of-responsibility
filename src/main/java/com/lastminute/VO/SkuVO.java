package com.lastminute.VO;

import java.util.UUID;

/**
 * Representation of the product. Typically there is a relationship between
 * Product and Sku allowing the latter to hold product variations such as color,
 * size, etc. For code readability we will simplify the example.
 * 
 * @author Manuel Moranchel
 *
 */
public class SkuVO {
	private String id;
	private String productName;
	private double listPrice;
	private boolean isImported;
	private Type skuType;
	
	public enum Type { FOOD, BOOKS, MEDICAL, OTHER}

	public SkuVO(String id, String productName, double listPrice, boolean isImported, Type skuType) {
		super();
		this.id = id;
		this.productName = productName;
		this.listPrice = listPrice;
		this.isImported = isImported;
		this.skuType = skuType;
	}

	public SkuVO() {
		super();
		this.id = UUID.randomUUID().toString();
		this.productName = "";
		this.listPrice = 0.0;
		this.isImported = false;
		this.skuType = Type.OTHER;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public Type getSkuType() {
		return skuType;
	}

	public void setSkuType(Type skuType) {
		this.skuType = skuType;
	}

	@Override
	public String toString() {
		return "SkuVO [id=" + id + ", productName=" + productName + ", listPrice=" + listPrice + ", isImported="
				+ isImported + ", skuType=" + skuType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isImported ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(listPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((skuType == null) ? 0 : skuType.hashCode());
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
		SkuVO other = (SkuVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isImported != other.isImported)
			return false;
		if (Double.doubleToLongBits(listPrice) != Double.doubleToLongBits(other.listPrice))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (skuType != other.skuType)
			return false;
		return true;
	}


}
