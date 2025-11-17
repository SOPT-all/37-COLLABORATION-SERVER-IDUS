package org.sopt.idus.domain.product.dto;

import org.sopt.idus.domain.author.entity.Author;
import org.sopt.idus.domain.product.entity.Product;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        Integer price,
        BigDecimal discountRate,
        Integer salesCount,
        Integer reviewCount,
        Integer likeCount,
        Author author
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDiscountRate(),
                product.getSalesCount(),
                product.getReviewCount(),
                product.getLikeCount(),
                product.getAuthor()
        );
    }
}
