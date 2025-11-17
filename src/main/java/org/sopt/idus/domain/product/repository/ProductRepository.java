package org.sopt.idus.domain.product.repository;

import org.sopt.idus.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
