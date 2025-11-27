package org.sopt.idus.domain.author.service;

import lombok.RequiredArgsConstructor;
import org.sopt.idus.domain.author.dto.response.AuthorResponse;
import org.sopt.idus.domain.author.entity.Author;
import org.sopt.idus.domain.author.errorcode.AuthorErrorCode;
import org.sopt.idus.domain.author.repository.AuthorRepository;
import org.sopt.idus.domain.authorlike.dto.response.AuthorLikeResponse;
import org.sopt.idus.domain.authorlike.entity.AuthorLike;
import org.sopt.idus.domain.authorlike.repository.AuthorLikeRepository;
import org.sopt.idus.domain.user.entity.User;
import org.sopt.idus.domain.user.service.UserService;
import org.sopt.idus.global.exception.customexception.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorLikeRepository authorLikeRepository;
    private final UserService userService;

    public AuthorResponse getAuthorDetail(Long authorId, Long userId) {
        Author author = findById(authorId);

        boolean isLiked = authorLikeRepository.existsByAuthorIdAndUserId(authorId, userId);

        return AuthorResponse.from(author, isLiked);
    }

    @Transactional
    public AuthorLikeResponse createAuthorLike(Long authorId, Long userId) {
        Author author = findById(authorId);
        User user = userService.findById(userId);

        if(deleteLikeIfPresent(authorId, userId, author)) return AuthorLikeResponse.of(author);
        AuthorLike authorLike = AuthorLike.create(author, user);
        authorLikeRepository.save(authorLike);
        authorRepository.increaseLikeCount(author);

        return AuthorLikeResponse.of(author);
    }

    private boolean deleteLikeIfPresent(Long authorId, Long userId, Author author) {
        if(authorLikeRepository.existsByAuthorIdAndUserId(authorId, userId)) {
            authorLikeRepository.deleteByAuthorIdAndUserId(authorId, userId);
            authorRepository.decreaseLikeCount(author);
            return true;
        }
        return false;
    }

    private Author findById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new CustomException(AuthorErrorCode.AUTHOR_NOT_FOUND));
    }
}