package com.shu.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SellerProductPK implements Serializable{
    @Column(name = "product_id")
    Long productId;

    @Column(name = "seller_id")
    Long sellerId;
}
