package org.sopt.idus.domain.productlike.repository;

import org.sopt.idus.domain.productlike.entity.ProductLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLikeRepository extends JpaRepository<ProductLike, Long> {

    boolean existsByProductIdAndUserId(Long productId, Long userId);

    void deleteByProductIdAndUserId(Long productId, Long userId);
}
