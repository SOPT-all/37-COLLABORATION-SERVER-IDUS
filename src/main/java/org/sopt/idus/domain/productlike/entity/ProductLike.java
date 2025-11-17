package org.sopt.idus.domain.productlike.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.idus.domain.product.entity.Product;
import org.sopt.idus.domain.user.entity.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "product_like",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_product_like_user_product",
                        columnNames = {"user_id", "product_id"}
                )
        }
)
public class ProductLike {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    private ProductLike(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    public static ProductLike create(Product product, User user) {
        return new ProductLike(product, user);
    }
}
