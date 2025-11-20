package org.sopt.idus.domain.author.errorcode;

import lombok.RequiredArgsConstructor;
import org.sopt.idus.global.exception.errorcode.ErrorCode;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum AuthorErrorCode implements ErrorCode {
    AUTHOR_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "존재하지 않는 작가입니다.");

    private final int httpStatus;
    private final String message;

    @Override
    public int getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
