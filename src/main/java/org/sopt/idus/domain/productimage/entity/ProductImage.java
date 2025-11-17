package org.sopt.idus.domain.productimage.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.idus.domain.product.entity.Product;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String fileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Builder
    public ProductImage(String imageUrl, String fileName, Product product) {
        this.imageUrl = imageUrl;
        this.fileName = fileName;
        this.product = product;
    }
}
