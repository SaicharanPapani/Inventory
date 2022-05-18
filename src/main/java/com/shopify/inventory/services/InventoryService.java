package com.shopify.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.shopify.inventory.dao.InventoryItemsRepository;
import com.shopify.inventory.dao.WarehouseRepository;
import com.shopify.inventory.models.Item;
import com.shopify.inventory.models.ItemRequest;
import com.shopify.inventory.util.Utilities;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryItemsRepository repo;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	
	public String saveorEditInventoryItem(ItemRequest itemRequest) {
		try {
			Item item = itemRequest.getItem();
			if(item.getCostOfItem() == null) {
				throw new Exception("Cost of Each Item is mandatory!");
			}
			if(item.getItemCount() == null) {
				throw new Exception("Item count is mandatory!");
			}
			if(item.getItemCount() < 0 || item.getCostOfItem() < 0) {
				throw new Exception("Negative number are not allowed. Please correct it!");
			}
			if(item.getName() == null || item.getName().trim().length() == 0) {
				throw new Exception("Name of the item is mandatory!");
			}
			if(!Utilities.validateString(item.getName())) {
				throw new Exception("Name contain non-alpahbets. Please correct it!");
			}
			if(item.getBrandName() == null || item.getBrandName().trim().length() == 0) {
				throw new Exception("Brand name of the item is mandatory!");
			}
			if(!Utilities.validateString(item.getBrandName())) {
				throw new Exception("Brand Name contain non-alpahbets. Please correct it!");
			}
			if(itemRequest.getWarehouseId() != null) {
				item.setWarehouse(warehouseRepository.findById(itemRequest.getWarehouseId()).get());
			}
			repo.save(item);
			return "Item Saved Successfully!!";
		}catch (DataIntegrityViolationException e) {
			return "Item with the same brand name in the given warehouse already exist! please go head and edit the item name or brand name or warehouse location.";
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String DeleteInventoryItem(Long itemId) {
		try {
			if(!repo.findById(itemId).isPresent())
				throw new Exception("No Item exists with given itemId!!!");
			repo.deleteById(itemId);
			return "Item successfully deleted!";
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public List<Item> getAllItems(){
		return repo.findAll();
	}

	public Item getItemById(Long itemId) {
		return repo.getById(itemId);
	}
}
