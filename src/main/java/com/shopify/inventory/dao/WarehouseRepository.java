package com.shopify.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopify.inventory.models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long>  {

}
