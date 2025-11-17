package org.sopt.idus.domain.product.dto.response;

import org.sopt.idus.domain.product.entity.Product;
import org.sopt.idus.domain.productimage.entity.ProductImage;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponse(
        Long id,
        String name,
        Integer price,
        BigDecimal discountRate,
        Integer salesCount,
        Integer reviewCount,
        Integer likeCount,
        String authorName,
        List<String> imageUrls
) {
    public static ProductResponse from(Product product, List<ProductImage> productImageList) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDiscountRate(),
                product.getSalesCount(),
                product.getReviewCount(),
                product.getLikeCount(),
                product.getAuthor().getName(),
                productImageList.stream().map(ProductImage::getImageUrl).toList()
        );
    }
}
