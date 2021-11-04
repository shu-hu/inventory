package com.shu.inventory.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import com.shu.inventory.model.Seller;
import com.shu.inventory.repository.SellerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SellerController {
    private final Logger log = LoggerFactory.getLogger(SellerController.class);
    private SellerRepository sellerRepository;
    
    public SellerController(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
    
    @GetMapping("/sellers")
    Collection<Seller> sellers() {
        return sellerRepository.findAll();
    }
    
    // @GetMapping("/product/{product_id}")
    // ResponseEntity<?> getProduct(@PathVariable Long product_id) {
    //     Optional<Product> product = productRepository.findById(product_id);
    //     return product.map(response -> ResponseEntity.ok().body(response))
    //             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    // }
    
    @PostMapping("/seller")
    ResponseEntity<Seller> createProduct(@RequestBody Seller seller) throws URISyntaxException {
        log.info("Request to create seller: {}", seller);
        Seller result = sellerRepository.save(seller);
        return ResponseEntity.created(new URI("/api/group/" + result.getId()))
                .body(result);
    }
    
    // @PutMapping("/product")
    // ResponseEntity<Product> updateGroup(@RequestBody Product product) {
    //     log.info("Request to update product: {}", product);
    //     Product result = productRepository.save(product);
    //     return ResponseEntity.ok().body(result);
    // }
    
    // @DeleteMapping("/product/{product_id}")
    // public ResponseEntity<?> deleteProduct(@PathVariable Long product_id) {
    //     log.info("Request to delete product: {}", product_id);
    //     productRepository.deleteById(product_id);
    //     return ResponseEntity.ok().build();
    // }
}
