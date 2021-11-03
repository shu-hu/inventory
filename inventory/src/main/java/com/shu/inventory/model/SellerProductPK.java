package com.shu.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SellerProductPK implements Serializable{
    @Column(name = "PRODUCT_ID")
    private Long product_id;

    @Column(name = "SELLER_ID")
    private Long seller_id;
}
