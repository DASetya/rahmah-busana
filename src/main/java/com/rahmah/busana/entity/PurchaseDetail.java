package com.rahmah.busana.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "trx_purchase_detail")
@Getter
@Setter
public class PurchaseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double priceSell;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
    @ManyToOne
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;

    public PurchaseDetail() {
    }

    public PurchaseDetail(Long id, Double priceSell, Integer quantity, Purchase purchase, Clothes clothes) {
        this.id = id;
        this.priceSell = priceSell;
        this.quantity = quantity;
        this.purchase = purchase;
        this.clothes = clothes;
    }
}
