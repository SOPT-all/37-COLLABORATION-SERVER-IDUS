package org.sopt.idus.domain.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.idus.domain.product.entity.Product;
import org.sopt.idus.domain.productimage.entity.ProductImage;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponse(
        @Schema(description = "작품 ID", example = "1")
        Long id,

        @Schema(description = "작품명", example = "음성을 전하는 카세트 앨범 음성 편지")
        String name,

        @Schema(description = "원가", example = "15000")
        Integer price,

        @Schema(description = "할인율", example = "26")
        BigDecimal discountRate,

        @Schema(description = "구매 수", example = "4319")
        Integer salesCount,

        @Schema(description = "후기 수", example = "634")
        Integer reviewCount,

        @Schema(description = "작품 좋아요 수", example = "9999")
        Integer likeCount,

        @Schema(description = "좋아요 여부", example = "true")
        boolean isLiked,

        @Schema(description = "작가명")
        String authorName,

        @Schema(description = "작품 이미지")
        List<String> imageUrls,

        @Schema(description = "평균 별점", example = "4.8")
        double averageScore
) {
    public static ProductResponse from(Product product, List<ProductImage> productImageList, double averageScore, boolean isLiked) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDiscountRate(),
                product.getSalesCount(),
                product.getReviewCount(),
                product.getLikeCount(),
                isLiked,
                product.getAuthor().getName(),
                productImageList.stream().map(ProductImage::getImageUrl).toList(),
                averageScore
        );
    }
}
