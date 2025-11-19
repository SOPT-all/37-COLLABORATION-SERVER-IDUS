package org.sopt.idus.domain.author.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.sopt.idus.domain.author.dto.response.AuthorResponse;
import org.sopt.idus.domain.author.service.AuthorService;
import org.sopt.idus.global.annotation.CustomExceptionDescription;
import org.sopt.idus.global.config.swagger.SwaggerResponseDescription;
import org.sopt.idus.global.dto.response.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("authors")
public class AuthorController {

    private final AuthorService authorService;

    @CustomExceptionDescription(SwaggerResponseDescription.AUTHOR_DETAIL)
    @Operation(summary = "작가 정보 조회", description = "작가의 정보를 조회합니다.")
    @GetMapping("{authorId}")
    public BaseResponse<AuthorResponse> getAuthorDetail(@PathVariable Long authorId) {
        return BaseResponse.ok(authorService.getAuthorDetail(authorId), "작가 조회 성공");
    }
}
