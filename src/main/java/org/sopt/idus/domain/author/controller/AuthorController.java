package org.sopt.idus.domain.author.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.sopt.idus.domain.author.dto.response.AuthorResponse;
import org.sopt.idus.domain.author.service.AuthorService;
import org.sopt.idus.domain.authorlike.dto.request.AuthorLikeRequest;
import org.sopt.idus.domain.authorlike.dto.response.AuthorLikeResponse;
import org.sopt.idus.global.annotation.CustomExceptionDescription;
import org.sopt.idus.global.config.swagger.SwaggerResponseDescription;
import org.sopt.idus.global.dto.response.BaseResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("authors")
public class AuthorController {

    private final AuthorService authorService;

    @CustomExceptionDescription(SwaggerResponseDescription.AUTHOR_DETAIL)
    @Operation(summary = "작가 정보 조회", description = "작가의 정보를 조회합니다.")
    @GetMapping("{authorId}")
    public BaseResponse<AuthorResponse> getAuthorDetail(@PathVariable Long authorId, @RequestParam Long userId) {
        return BaseResponse.ok(authorService.getAuthorDetail(authorId, userId), "작가 조회 성공");
    }

    @CustomExceptionDescription(SwaggerResponseDescription.CREATE_AUTHOR_LIKE)
    @Operation(summary = "작가 좋아요 생성", description = "작가에게 좋아요를 생성합니다.")
    @PostMapping("{authorId}/likes")
    public BaseResponse<AuthorLikeResponse> createAuthorLike(@PathVariable Long authorId, @RequestBody AuthorLikeRequest req) {
        return BaseResponse.ok(authorService.createAuthorLike(authorId, req.userId()),"작가 좋아요 생성 성공");
    }
}
