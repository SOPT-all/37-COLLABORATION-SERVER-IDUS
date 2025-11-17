package org.sopt.idus.domain.review.dto;

import org.sopt.idus.domain.review.entity.Review;
import org.sopt.idus.domain.user.User;

import java.time.LocalDateTime;

public record ReviewResponse(
        Long reviewId,
        Integer score,
        String content,
        LocalDateTime createdAt,
        Reviewer reviewer
) {
    public static ReviewResponse from(Review review) {
        return new ReviewResponse(
                review.getId(),
                review.getScore(),
                review.getContent(),
                review.getCreatedAt(),
                Reviewer.from(review.getUser())
        );
    }

    public record Reviewer(
            Long id,
            String nickName,
            String imageUrl
    ) {
        public static Reviewer from(User user) {
            return new Reviewer(
                    user.getId(),
                    user.getNickname(),
                    user.getProfileImageUrl()
            );
        }
    }
}