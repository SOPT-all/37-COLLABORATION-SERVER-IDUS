package org.sopt.idus.domain.productlike.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.idus.domain.product.entity.Product;

public record ProductLikeResponse(
        @Schema(description = "좋아요 수", example = "123")
        int likeCount
) {
    public static ProductLikeResponse of(Product product) {
        return new ProductLikeResponse(product.getLikeCount());
    }
}
