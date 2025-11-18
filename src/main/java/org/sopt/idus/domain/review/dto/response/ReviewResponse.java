package org.sopt.idus.domain.review.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.idus.domain.review.entity.Review;
import org.sopt.idus.domain.user.entity.User;

import java.time.LocalDate;

public record ReviewResponse(
        @Schema(description = "리뷰 ID", example = "1")
        Long reviewId,

        @Schema(description = "별점", example = "4.0")
        double score,

        @Schema(description = "내용", example = "좋아요~")
        String content,

        @Schema(description = "리뷰 생성일", example = "2025-11-01")
        LocalDate createdAt,

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
            @Schema(description = "유저 ID", example = "1")
            Long userId,

            @Schema(description = "유저 닉네임", example = "임지성")
            String nickname,

            @Schema(description = "유저 프로필 이미지")
            String profileImageUrl
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