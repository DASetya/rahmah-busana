package com.rahmah.busana.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "pakaian")
@Getter
@Setter
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "clothes_name")
    private String clothesName;
    private String brand;
    private String material;
    private String description;
    private Integer stock;
    private Integer price;

    public Clothes() {
    }

    public Clothes(Long id, String clothesName, String merk, String bahan, String description, Integer stock, Integer price) {
        this.id = id;
        this.clothesName = clothesName;
        this.brand = brand;
        this.material = material;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }
}
