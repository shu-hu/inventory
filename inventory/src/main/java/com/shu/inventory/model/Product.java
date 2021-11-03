package com.shu.inventory.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

        @NonNull
        private String name;
        @NonNull
        private String sku;
        @NonNull
        private Timestamp createdate;

        public String toString() {
            return String.format("product id=%d, product name='%s', product sku='%s', create date=%s", id, name, sku, createdate);
        }
	
        public Product(String name, String sku, Timestamp createdate) {
            this.name = name;
            this.sku = sku;
            this.createdate = createdate;
        }
}
