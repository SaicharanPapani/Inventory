package com.shopify.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopify.inventory.models.Item;
import com.shopify.inventory.models.ItemRequest;
import com.shopify.inventory.models.Warehouse;
import com.shopify.inventory.services.InventoryService;
import com.shopify.inventory.services.WarehouseService;

@Controller
public class Controllers {
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private WarehouseService warehouseService;
	
	@GetMapping("/")
	public String dashboard(Model model, @ModelAttribute("edit") String edit) {
		if(edit != null && edit.trim().equals("edit")) {
			return "dashboard";
		}
		model.addAttribute("items", inventoryService.getAllItems());
		model.addAttribute("itemRequest", new ItemRequest());
		model.addAttribute("warehouse", new Warehouse());
		model.addAttribute("warehouses", warehouseService.getAllWarehouses());
		return "dashboard";
	}
	
	@PostMapping("/createWarehouse")
	public String createWarehouse(Model model, @ModelAttribute Warehouse warehouse, RedirectAttributes redirAttrs){
		redirAttrs.addFlashAttribute("message", warehouseService.createWarehouse(warehouse));
		return "redirect:/";
	}

	@PostMapping("/createItem")
	public String createItem(Model model, @ModelAttribute ItemRequest itemRequest, RedirectAttributes redirAttrs){
		redirAttrs.addFlashAttribute("message", inventoryService.saveorEditInventoryItem(itemRequest));
		return "redirect:/";
	}
	
	@PostMapping("/deleteItem/{id}")
	public String deleteItem(Model model, @PathVariable("id") Long itemId, RedirectAttributes redirAttrs){
		redirAttrs.addFlashAttribute("message", inventoryService.DeleteInventoryItem(itemId));
		return "redirect:/";
	}
	
	@PostMapping("/editItem/{id}")
	public String editItem(Model model, @PathVariable("id") Long itemId, RedirectAttributes redirAttrs) {
		redirAttrs.addFlashAttribute("edit", "edit");
		redirAttrs.addFlashAttribute("items", inventoryService.getAllItems());
		ItemRequest iR = new ItemRequest();
		Item i = inventoryService.getItemById(itemId);
		iR.setItem(i);
		iR.setWarehouseId(i.getWarehouse().getWarehouseId());
		redirAttrs.addFlashAttribute("itemRequest", iR);
		redirAttrs.addFlashAttribute("warehouse", new Warehouse());
		redirAttrs.addFlashAttribute("warehouses", warehouseService.getAllWarehouses());
		return "redirect:/";
	}
}
