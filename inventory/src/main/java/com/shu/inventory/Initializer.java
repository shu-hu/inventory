package com.shu.inventory;

import java.util.ArrayList;
import java.util.Arrays;

import com.shu.inventory.model.Product;
import com.shu.inventory.model.Seller;
import com.shu.inventory.model.SellerProduct;
import com.shu.inventory.repository.ProductRepository;
import com.shu.inventory.repository.SellerProductRepository;
import com.shu.inventory.repository.SellerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class Initializer implements CommandLineRunner{
    private final ProductRepository productrepository;
    private final SellerRepository sellerrepository;

    private final SellerProductRepository sellerproductrepository;

    public Initializer(ProductRepository productrepository, SellerRepository sellerrepository, SellerProductRepository sellerproductrepository) {
        this.productrepository = productrepository;
        this.sellerrepository = sellerrepository;
        this.sellerproductrepository = sellerproductrepository;
    }

    @Override
    public void run(String... strings) {
        // productrepository.deleteAll();
        // sellerrepository.deleteAll();

        // ArrayList<Product> products = new ArrayList<Product>( Arrays.asList(
        //     new Product("Jurassic", "XA-SAB6-3HK4"),
        //     new Product("World", "XA-SAB6-3HK4")));
        
        // System.out.println(products);

        // productrepository.saveAll(products);

        // ArrayList<Seller> sellers = new ArrayList<Seller>( Arrays.asList(
        //     new Seller("Amazon"),
        //     new Seller("Target")));
        
        // System.out.println(sellers);

        // sellerrepository.saveAll(sellers);
        System.out.println(this.productrepository.findAll());
        System.out.println(this.sellerrepository.findAll());
        
        Long productIdA = 20L;
        Long productIdB = 25L;
        Long sellerA = 22L;
        Long sellerB = 23L;

        System.out.println(this.productrepository.findById(productIdB).orElse(null));

        this.sellerproductrepository.deleteAll();
        ArrayList<SellerProduct> sellerproducts = new ArrayList<SellerProduct>( Arrays.asList(
            new SellerProduct(
                this.productrepository.findById(productIdA).orElse(null),
                this.sellerrepository.findById(sellerA).orElse(null),
                20.00,
                3
            ),
            new SellerProduct(
                this.productrepository.findById(productIdB).orElse(null),
                this.sellerrepository.findById(sellerB).orElse(null),
                5.10,
                2
            ),
            new SellerProduct(
                this.productrepository.findById(productIdA).orElse(null),
                this.sellerrepository.findById(sellerB).orElse(null),
                120.00,
                13
            )
            ));
        
        System.out.println(sellerproducts);

        sellerproductrepository.saveAll(sellerproducts);

        productrepository.findAll().forEach(System.out::println);
        sellerrepository.findAll().forEach(System.out::println);
        sellerproductrepository.findAll().forEach(System.out::println);
    }
}
