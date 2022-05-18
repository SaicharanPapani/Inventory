package com.shopify.inventory.models;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(
        name="warehouse", 
        uniqueConstraints=
            @UniqueConstraint(columnNames={"warehouseName"})
    )
public class Warehouse {
	@Id
	@Column
	@GeneratedValue
	private Long warehouseId;
	
	@Column
	private String warehouseName;
	
	@Column
	private String warehouseLocation;
	
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getWarehouseLocation() {
		return warehouseLocation;
	}
	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}
	public Warehouse(Long warehouseId, String warehouseName, String warehouseLocation) {
		super();
		this.warehouseId = warehouseId;
		this.warehouseName = warehouseName;
		this.warehouseLocation = warehouseLocation;
	}
	public Warehouse() {
		super();
	}

	
	
	
}
