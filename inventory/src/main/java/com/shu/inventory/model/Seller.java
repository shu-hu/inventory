package com.shu.inventory.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue
    private Long seller_id;

    @OneToMany(mappedBy = "product")
    private Set<SellerProduct> product = new HashSet<SellerProduct>();

    @NonNull
    private String name;


    public String toString() {
        return String.format("seller id=%d, seller name='%s'", seller_id, name);
    }

    // public Seller(String name) {
    //     this.name = name;
    // }
}
