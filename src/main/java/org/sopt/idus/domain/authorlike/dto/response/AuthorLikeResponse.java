package org.sopt.idus.domain.authorlike.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.idus.domain.author.entity.Author;

public record AuthorLikeResponse(
        @Schema(description = "좋아요 수", example = "523")
        int likeCount
) {
    public static AuthorLikeResponse of(Author author) {
        return new AuthorLikeResponse(author.getLikeCount());
    }
}
