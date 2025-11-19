package org.sopt.idus.domain.author.service;

import lombok.RequiredArgsConstructor;
import org.sopt.idus.domain.author.dto.response.AuthorResponse;
import org.sopt.idus.domain.author.entity.Author;
import org.sopt.idus.domain.author.errorcode.AuthorErrorCode;
import org.sopt.idus.domain.author.repository.AuthorRepository;
import org.sopt.idus.global.exception.customexception.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorResponse getAuthorDetail(Long authorId) {
        Author author = findById(authorId);

        return AuthorResponse.from(author);
    }

    private Author findById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new CustomException(AuthorErrorCode.AUTHOR_NOT_FOUND));
    }
}