package org.sopt.idus.domain.productimage.repository;

import org.sopt.idus.domain.productimage.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
    List<ProductImage> findAllByProductId(Long productId);
}
