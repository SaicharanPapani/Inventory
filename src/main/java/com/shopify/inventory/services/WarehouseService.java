package com.shopify.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.shopify.inventory.dao.WarehouseRepository;
import com.shopify.inventory.models.Warehouse;
import com.shopify.inventory.util.Utilities;

@Service
public class WarehouseService {

	@Autowired
	private WarehouseRepository repo;
	
	public String createWarehouse(Warehouse warehouse) {
		try {
			if(warehouse.getWarehouseLocation() == null || warehouse.getWarehouseLocation().trim().length() == 0) {
				throw new Exception("location is required!!");
			}
			if(warehouse.getWarehouseName() == null || warehouse.getWarehouseName().trim().length() == 0) {
				throw new Exception("Warehouse name is required!!");
			}
			if(!Utilities.validateString(warehouse.getWarehouseName())) {
				throw new Exception("Warehouse name contains non-alpahbets. Please correct it!");
			}
			repo.save(warehouse);
			return "Warehouse successfully created!!!";
		}catch (DataIntegrityViolationException e) {
			return "Warehouse name already exist! Please name it unique.";
		}
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public List<Warehouse> getAllWarehouses(){
		return repo.findAll();
	}
}
