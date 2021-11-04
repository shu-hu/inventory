package com.shu.inventory.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.shu.inventory.model.SellerProduct;
import com.shu.inventory.repository.SellerProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class SellerProductController {
    private final Logger log = LoggerFactory.getLogger(SellerProductController.class);
    private SellerProductRepository sellerProductRepository;
    
    public SellerProductController(SellerProductRepository sellerProductRepository) {
        this.sellerProductRepository = sellerProductRepository;
    }
    
    @GetMapping("/sellerproducts")
    Collection<SellerProduct> sellerProducts() {
        return sellerProductRepository.findAll();
    }
    
    @GetMapping("/sellerproduct")
    ResponseEntity<List<SellerProduct>> getSellerProduct(
            @RequestParam Long product_id
        ) {
        List<SellerProduct> sellerProducts = sellerProductRepository.findByProductId(product_id, Sort.by(Sort.Direction.DESC, "price"));
		return new ResponseEntity<List<SellerProduct>>(sellerProducts, HttpStatus.OK);
    }
    
    @PostMapping("/sellerproduct")
    ResponseEntity<SellerProduct> createSellerProduct(@RequestBody SellerProduct sellerProduct) throws URISyntaxException {
        log.info("Request to create sellerProduct: {}", sellerProduct);
        SellerProduct result = sellerProductRepository.save(sellerProduct);
        return ResponseEntity.created(new URI("/api/group/"))
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
