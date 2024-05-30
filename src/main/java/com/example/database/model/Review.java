package com.example.database.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewid")
    private int reviewId;

    @Column(name="reviewcontent")
    private String reviewContent;

    @Column(name = "rating")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;
}
