package org.sopt.idus.domain.product.service;


import lombok.RequiredArgsConstructor;
import org.sopt.idus.domain.product.dto.response.ProductResponse;
import org.sopt.idus.domain.product.entity.Product;
import org.sopt.idus.domain.product.repository.ProductRepository;
import org.sopt.idus.domain.productimage.entity.ProductImage;
import org.sopt.idus.domain.productimage.repository.ProductImageRepository;
import org.sopt.idus.domain.review.entity.Review;
import org.sopt.idus.domain.review.repository.ReviewRepository;
import org.sopt.idus.global.exception.customexception.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.sopt.idus.domain.product.errorcode.ProductErrorCode.PRODUCT_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductImageRepository productImageRepository;

    private final ReviewRepository reviewRepository;

    public ProductResponse getProductDetail(Long productId){
        Product product = findById(productId);

        List<ProductImage> productImages = productImageRepository.findAllByProductId(productId);

        List<Review> reviews = reviewRepository.findAllByProductId(productId);

        double averageScore = reviews.stream()
                .mapToInt(Review::getScore)
                .average()
                .orElse(0.0);

        return ProductResponse.from(product, productImages, averageScore);
    }

    private Product findById(Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new CustomException(PRODUCT_NOT_FOUND));
    }

}
