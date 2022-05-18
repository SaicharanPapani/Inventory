package com.shopify.inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.inventory.models.Warehouse;
import com.shopify.inventory.services.WarehouseService;

@RestController
@RequestMapping(path = "/warehouse")
public class WarehouseController {
	
	@Autowired
	private WarehouseService warehouseService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createWarehouse(@RequestBody Warehouse warehouse){
		return ResponseEntity.ok(warehouseService.createWarehouse(warehouse));
	}
	
	@GetMapping("/getAllWarehouses")
	public ResponseEntity<List<Warehouse>> getAllWarehouses(){
		return ResponseEntity.ok(warehouseService.getAllWarehouses());
	}
	
}
