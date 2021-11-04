package com.shu.inventory.repository;

import java.util.List;

import com.shu.inventory.model.SellerProduct;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerProductRepository extends JpaRepository<SellerProduct, Long>{
    List<SellerProduct> findByProductId(Long productId, Sort sort);
}