package org.sopt.idus.domain.review.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.idus.domain.product.entity.Product;
import org.sopt.idus.domain.user.entity.User;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "review",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_review_user_product",
                        columnNames = {"user_id", "product_id"}
                )
        }
)
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;

    private String content;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Review(Integer score, String content, Product product, User user) {
        this.score = score;
        this.content = content;
        this.product = product;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }
}
