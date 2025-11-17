package org.sopt.idus.domain.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.sopt.idus.domain.product.dto.response.ProductResponse;
import org.sopt.idus.domain.product.service.ProductService;
import org.sopt.idus.global.annotation.CustomExceptionDescription;
import org.sopt.idus.global.dto.response.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
