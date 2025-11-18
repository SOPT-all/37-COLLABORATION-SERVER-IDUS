package org.sopt.idus.domain.review.dto.response;

import org.sopt.idus.domain.review.entity.Review;

import java.util.List;

public record ReviewListResponse(
        List<ReviewResponse> reviewResponses
) {
    public static ReviewListResponse from(List<Review> reviews) {
        return new ReviewListResponse(reviews.stream()
                .map(ReviewResponse::from)
                .toList());
    }
}
