package com.shu.inventory.repository;

import com.shu.inventory.model.Seller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long>{
    Seller findByName(String name);
}