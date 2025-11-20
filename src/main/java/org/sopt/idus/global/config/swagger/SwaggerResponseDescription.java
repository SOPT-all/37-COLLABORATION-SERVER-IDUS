package org.sopt.idus.global.config.swagger;

import lombok.Getter;
import org.sopt.idus.global.exception.errorcode.ErrorCode;
import org.sopt.idus.global.exception.errorcode.GlobalErrorCode;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.sopt.idus.domain.author.errorcode.AuthorErrorCode.AUTHOR_NOT_FOUND;
import static org.sopt.idus.domain.product.errorcode.ProductErrorCode.PRODUCT_NOT_FOUND;
import static org.sopt.idus.domain.user.errorcode.UserErrorCode.USER_NOT_FOUND;

@Getter
public enum SwaggerResponseDescription {
    COMMON(new LinkedHashSet<>(Set.of(
    ))),
    PRODUCT_DETAIL(new LinkedHashSet<>(Set.of(
            PRODUCT_NOT_FOUND
    ))),
    CREATE_PRODUCT_LIKE(new LinkedHashSet<>(Set.of(
            PRODUCT_NOT_FOUND,
            USER_NOT_FOUND
    ))),
    GET_REVIEWS(new LinkedHashSet<>(Set.of(
            PRODUCT_NOT_FOUND
    ))),
    AUTHOR_DETAIL(new LinkedHashSet<>(Set.of(
    ))),
    CREATE_AUTHOR_LIKE(new LinkedHashSet<>(Set.of(
            AUTHOR_NOT_FOUND,
            USER_NOT_FOUND
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
