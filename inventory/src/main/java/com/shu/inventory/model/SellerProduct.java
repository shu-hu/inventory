package com.shu.inventory.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "SellerProduct")
public class SellerProduct implements Serializable{

    @EmbeddedId
    private SellerProductPK id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @MapsId("seller_id")
    @JoinColumn(name = "SELLER_ID")
    private Seller seller;  

    @NonNull
    private String price;
    @NonNull
    private int inventoryAmount;
}
