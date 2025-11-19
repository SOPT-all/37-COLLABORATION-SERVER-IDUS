package org.sopt.idus.domain.authorlike.repository;

public interface AuthorLikeRepository {
    boolean existsByAuthorIdAndUserId(Long authorId, Long userId);

    void deleteByAuthorIdAndUserId(Long authorId, Long userId);
}
