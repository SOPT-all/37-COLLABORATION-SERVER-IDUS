package org.sopt.idus.domain.author.dto.response;

import org.sopt.idus.domain.author.entity.Author;

public record AuthorResponse(
        Long id,
        String name,
        String description,
        String imageUrl,
        Integer likeCount
) {
    public static AuthorResponse from(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getDescription(),
                author.getImageUrl(),
                author.getLikeCount()
        );
    }
}
