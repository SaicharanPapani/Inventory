package com.shopify.inventory.models;

public class ItemRequest {
	
	private Item item;
	private Long warehouseId;
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	public ItemRequest(Item item, Long warehouseId) {
		super();
		this.item = item;
		this.warehouseId = warehouseId;
	}
	public ItemRequest() {
		super();
	}
	
	

}
