package org.sopt.idus.domain.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.sopt.idus.domain.product.dto.response.ProductResponse;
import org.sopt.idus.domain.product.service.ProductService;
import org.sopt.idus.domain.productlike.dto.ProductLikeRequest;
import org.sopt.idus.global.annotation.CustomExceptionDescription;
import org.sopt.idus.global.dto.response.BaseResponse;
import org.springframework.web.bind.annotation.*;

import static org.sopt.idus.global.config.swagger.SwaggerResponseDescription.CREATE_PRODUCT_LIKE;
import static org.sopt.idus.global.config.swagger.SwaggerResponseDescription.PRODUCT_DETAIL;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @CustomExceptionDescription(PRODUCT_DETAIL)
    @Operation(summary = "작품 정보 조회", description = "작품의 정보를 조회합니다.")
    @GetMapping("{productId}")
    public BaseResponse<ProductResponse> getProductDetail(@PathVariable Long productId){
        return BaseResponse.ok(productService.getProductDetail(productId),"작품 조회 성공");
    }

    @CustomExceptionDescription(CREATE_PRODUCT_LIKE)
    @Operation(summary = "작품 좋아요 생성", description = "작품에 좋아요를 생성합니다.")
    @PostMapping("{productId}/likes")
    public BaseResponse<Void> likeProduct(@PathVariable Long productId, @RequestBody ProductLikeRequest request){
        productService.createProductLike(productId, request.userId());
        return BaseResponse.ok("작품 좋아요 생성 성공");
    }



}
