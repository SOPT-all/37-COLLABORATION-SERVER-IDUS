package org.sopt.idus.domain.product.repository;

import org.sopt.idus.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query("update Product p set p.likeCount = p.likeCount + 1 where p = :product")
    void increaseLikeCount(Product product);

    @Modifying
    @Query("update Product p set p.likeCount = p.likeCount - 1 where p = :product")
    void decreaseLikeCount(Product product);

}
