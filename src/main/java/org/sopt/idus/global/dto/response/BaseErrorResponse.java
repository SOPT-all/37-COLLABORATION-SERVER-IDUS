package org.sopt.idus.global.dto.response;

import org.sopt.idus.global.exception.errorcode.ErrorCode;


public record BaseErrorResponse(int code, String message, String messageDetail) {
    public static BaseErrorResponse of(int code, String message, String messageDetail) {
        return new BaseErrorResponse(code, message, messageDetail);
    }

    public static BaseErrorResponse of(ErrorCode errorCode) {
        return new BaseErrorResponse(errorCode.getHttpStatus(), errorCode.getMessage(), null);
    }

    public static BaseErrorResponse of(ErrorCode errorCode, String messageDetail) {
        return new BaseErrorResponse(errorCode.getHttpStatus(), errorCode.getMessage(), messageDetail);
    }

}
