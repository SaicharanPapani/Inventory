package com.shopify.inventory.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name="Items", 
    uniqueConstraints=
        @UniqueConstraint(columnNames={"name", "brandName", "warehouse_warehouse_id"})
)
public class Item {
	@Id
	@Column
	@GeneratedValue
	private Long itemId;
	@Column
	private String name;
	@Column
	private String brandName;
	@Column
	private Integer itemCount;
	@Column
	private Double costOfItem;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Warehouse warehouse;
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getItemCount() {
		return itemCount;
	}
	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}
	public Double getCostOfItem() {
		return costOfItem;
	}
	public void setCostOfItem(Double costOfItem) {
		this.costOfItem = costOfItem;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Item(Long itemId, String name, String brandName, Integer itemCount, Double costOfItem, Warehouse warehouse) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.brandName = brandName;
		this.itemCount = itemCount;
		this.costOfItem = costOfItem;
		this.warehouse = warehouse;
	}
	public Item() {
		super();
	}
	

}
