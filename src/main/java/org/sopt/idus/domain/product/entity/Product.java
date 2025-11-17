package org.sopt.idus.domain.product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.idus.domain.author.entity.Author;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    @Column(precision = 4, scale = 1)
    private BigDecimal discountRate;

    private Integer salesCount;

    private Integer reviewCount;

    private Integer likeCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @Builder
    public Product(String name, Integer price, BigDecimal discountRate, Integer salesCount, Integer reviewCount, Integer likeCount, Author author) {
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.salesCount = (salesCount ==  null) ? 0 : salesCount;
        this.reviewCount = (reviewCount ==  null) ? 0 : reviewCount;
        this.likeCount = (likeCount == null) ? 0 : likeCount;
        this.author = author;
    }
}