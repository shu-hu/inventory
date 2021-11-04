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
        this.sellerproductrepository.deleteAll();
        this.productrepository.deleteAll();
        this.sellerrepository.deleteAll();

        Product productA = new Product("Jurassic World Lego", "XA-SAB6-3HK4");
        Product productB = new Product("Naruto Funko Pop", "BA-SAB6-37HH");
        productrepository.save(productA);
        productrepository.save(productB);
        // ArrayList<Product> products = new ArrayList<Product>( Arrays.asList(
        //     new Product("Jurassic", "XA-SAB6-3HK4"),
        //     new Product("World", "XA-SAB6-3HK4")));
        
        // System.out.println();

        // productrepository.saveAll(products);

        Seller sellerA = new Seller("Amazon");
        Seller sellerB = new Seller("Target");
        sellerrepository.save(sellerA);
        sellerrepository.save(sellerB);
        // ArrayList<Seller> sellers = new ArrayList<Seller>( Arrays.asList(
        //     new Seller("Amazon"),
        //     new Seller("Target")));
        
        // System.out.println(sellers);

        // sellerrepository.saveAll(sellers);
        System.out.println(this.productrepository.findAll());
        System.out.println(this.sellerrepository.findAll());
        
        // Long productIdA = 20L;
        // Long productIdB = 25L;
        // Long sellerA = 22L;
        // Long sellerB = 23L;

        // System.out.println(this.productrepository.findById(productIdB).orElse(null));

        ArrayList<SellerProduct> sellerproducts = new ArrayList<SellerProduct>( Arrays.asList(
            new SellerProduct(
                productA,
                sellerA,
                120.00,
                3
            ),
            new SellerProduct(
                productA,
                sellerB,
                100.00,
                30
            ),
            new SellerProduct(
                productB,
                sellerB,
                10.00,
                14
            )
            // new SellerProduct(
            //     this.productrepository.findById(productIdA).orElse(null),
            //     this.sellerrepository.findById(sellerA).orElse(null),
            //     20.00,
            //     3
            // ),
            // new SellerProduct(
            //     this.productrepository.findById(productIdB).orElse(null),
            //     this.sellerrepository.findById(sellerB).orElse(null),
            //     5.10,
            //     2
            // ),
            // new SellerProduct(
            //     this.productrepository.findById(productIdA).orElse(null),
            //     this.sellerrepository.findById(sellerB).orElse(null),
            //     120.00,
            //     13
            // )
            ));
        
        System.out.println(sellerproducts);

        sellerproductrepository.saveAll(sellerproducts);

        productrepository.findAll().forEach(System.out::println);
        sellerrepository.findAll().forEach(System.out::println);
        sellerproductrepository.findAll().forEach(System.out::println);
    }
}
