package org.sopt.idus.global.config.swagger;

import lombok.Getter;
import org.sopt.idus.global.exception.errorcode.ErrorCode;
import org.sopt.idus.global.exception.errorcode.GlobalErrorCode;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
public enum SwaggerResponseDescription {
    COMMON(new LinkedHashSet<>(Set.of(
    )))

    ;
    private final Set<ErrorCode> errorCodeList;
    SwaggerResponseDescription(Set<ErrorCode> specificErrorCodes) {
        this.errorCodeList = new LinkedHashSet<>();
        this.errorCodeList.addAll(specificErrorCodes);
        this.errorCodeList.addAll(getGlobalErrorCodes());
    }

    private Set<ErrorCode> getGlobalErrorCodes() {
        return new LinkedHashSet<>(Set.of(GlobalErrorCode.values()));
    }
}
