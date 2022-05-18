package com.shopify.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.shopify.inventory.dao.InventoryItemsRepository;
import com.shopify.inventory.dao.WarehouseRepository;
import com.shopify.inventory.models.Item;
import com.shopify.inventory.models.ItemRequest;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryItemsRepository repo;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	public String saveorEditInventoryItem(ItemRequest itemRequest) {
		try {
			if(itemRequest.getItem().getCostOfItem() == null) {
				throw new Exception("Cost of Each Item is mandatory!");
			}
			if(itemRequest.getItem().getItemCount() == null) {
				throw new Exception("Item count is mandatory!");
			}
			if(itemRequest.getItem().getName() == null || itemRequest.getItem().getName().trim().length() == 0) {
				throw new Exception("Name of the item is mandatory!");
			}
			if(itemRequest.getItem().getBrandName() == null || itemRequest.getItem().getBrandName().trim().length() == 0) {
				throw new Exception("Brand name of the item is mandatory!");
			}
			if(itemRequest.getWarehouseId() != null) {
				itemRequest.getItem().setWarehouse(warehouseRepository.findById(itemRequest.getWarehouseId()).get());
			}
			repo.save(itemRequest.getItem());
			
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
