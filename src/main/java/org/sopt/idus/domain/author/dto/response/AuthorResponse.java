package org.sopt.idus.domain.author.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.idus.domain.author.entity.Author;

public record AuthorResponse(
        @Schema(description = "작가 ID", example = "1")
        Long id,

        @Schema(description = "작가명", example = "SPEDEAR")
        String name,

        @Schema(description = "작가소개", example = "소중한 순간을 담을 수 있는 아이템을 만듭니다.")
        String description,

        @Schema(description = "작가 이미지")
        String imageUrl,

        @Schema(description = "작가 좋아요 수", example = "9999")
        Integer likeCount,

        @Schema(description = "좋아요 여부", example = "true")
        boolean isLiked
) {
    public static AuthorResponse from(Author author, boolean isLiked) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getDescription(),
                author.getImageUrl(),
                author.getLikeCount(),
                isLiked
        );
    }
}
