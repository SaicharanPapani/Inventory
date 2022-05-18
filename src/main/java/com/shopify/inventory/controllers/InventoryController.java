package com.shopify.inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.inventory.models.Item;
import com.shopify.inventory.models.ItemRequest;
import com.shopify.inventory.services.InventoryService;

@RestController
@RequestMapping(path="/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/savecreate")
	public ResponseEntity<String> saveItem(@RequestBody ItemRequest itemRequest){
		return ResponseEntity.ok(inventoryService.saveorEditInventoryItem(itemRequest));
	}
	
	@PostMapping("/delete/{itemId}")
	public ResponseEntity<String> deleteItem(@PathVariable Long itemId, @RequestBody(required = false) String deletionComments){
		return ResponseEntity.ok(inventoryService.DeleteInventoryItem(itemId));
	}
	
	@GetMapping("/getAllItems")
	public ResponseEntity<List<Item>> getAllInventoryItems(){
		return ResponseEntity.ok(inventoryService.getAllItems());
	}
}
