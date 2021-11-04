package com.shu.inventory.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
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
    @Column(name="product_id")
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String sku;


    private Date createdate;

    public String toString() {
        return String.format("product id=%d, product name='%s', product sku='%s', create date=%s", id, name, sku, createdate);
    }


    public Long getId(){
        return this.id;
    }

    @PrePersist
    protected void onCreate() {
        this.createdate = new Date();
    }
}
