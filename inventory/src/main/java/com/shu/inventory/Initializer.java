package com.shu.inventory;

import java.util.ArrayList;
import java.util.Arrays;

import com.shu.inventory.model.Product;
import com.shu.inventory.repository.ProductRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class Initializer implements CommandLineRunner{
    private final ProductRepository repository;

    public Initializer(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {

        ArrayList<Product> products = new ArrayList<Product>( Arrays.asList(
            new Product("Jurassic", "XA-SAB6-3HK4"),
            new Product("World", "XA-SAB6-3HK4")));
        
        System.out.println(products);

        repository.saveAll(products);

        repository.findAll().forEach(System.out::println);
    }
}
