package com.example.database.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int productId;

    @Column(name = "productname")
    private String productName;

    @Column(name = "price")
    private double price;




}
