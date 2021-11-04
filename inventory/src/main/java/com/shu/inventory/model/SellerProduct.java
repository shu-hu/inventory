package com.shu.inventory.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "SellerProduct")
public class SellerProduct implements Serializable{

    @EmbeddedId
    private SellerProductPK id = new SellerProductPK();

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    @NonNull
    @Setter
    @Getter
    private Product product;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId("sellerId")
    @JoinColumn(name = "seller_id")
    @NonNull
    @Setter
    @Getter
    private Seller seller;  

    @NonNull
    @Setter
    @Getter
    private double price;
    @NonNull
    @Setter
    @Getter
    private int inventoryAmount;
}
