package org.sopt.idus.domain.product.service;


import lombok.RequiredArgsConstructor;
import org.sopt.idus.domain.product.dto.response.ProductResponse;
import org.sopt.idus.domain.product.entity.Product;
import org.sopt.idus.domain.product.repository.ProductRepository;
import org.sopt.idus.domain.productimage.entity.ProductImage;
import org.sopt.idus.domain.productimage.repository.ProductImageRepository;
import org.sopt.idus.domain.productlike.entity.ProductLike;
import org.sopt.idus.domain.productlike.repository.ProductLikeRepository;
import org.sopt.idus.domain.review.dto.response.ReviewListResponse;
import org.sopt.idus.domain.review.entity.Review;
import org.sopt.idus.domain.review.repository.ReviewRepository;
import org.sopt.idus.domain.user.entity.User;
import org.sopt.idus.domain.user.service.UserService;
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

    private final UserService userService;

    private final ProductLikeRepository productLikeRepository;

    public ProductResponse getProductDetail(Long productId){
        Product product = findById(productId);

        List<ProductImage> productImages = productImageRepository.findAllByProductId(productId);

        List<Review> reviews = reviewRepository.findAllByProductId(productId);

        double averageScore = reviews.stream()
                .mapToDouble(Review::getScore)
                .average()
                .orElse(0.0);

        return ProductResponse.from(product, productImages, averageScore);
    }

    private Product findById(Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new CustomException(PRODUCT_NOT_FOUND));
    }

    @Transactional
    public void createProductLike(Long productId, Long userId) {
        Product product = findById(productId);
        User user = userService.findById(userId);

        if (deleteLikeIfPresent(productId, userId, product)) return;

        ProductLike productLike = ProductLike.create(product, user);
        productLikeRepository.save(productLike);

        productRepository.increaseLikeCount(product);

    }

    private boolean deleteLikeIfPresent(Long productId, Long userId, Product product) {
        if(productLikeRepository.existsByProductIdAndUserId(productId, userId)){
            productLikeRepository.deleteByProductIdAndUserId(productId, userId);
            productRepository.decreaseLikeCount(product);
            return true;
        }
        return false;
    }

    public ReviewListResponse getReviews(Long productId) {
        Product product = findById(productId);

        List<Review> reviews = reviewRepository.findAllByProductId(productId);

        return ReviewListResponse.from(reviews);
    }


}
