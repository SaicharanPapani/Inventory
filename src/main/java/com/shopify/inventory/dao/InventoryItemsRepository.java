package com.shopify.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopify.inventory.models.Item;

@Repository
public interface InventoryItemsRepository extends JpaRepository<Item, Long> {

}
