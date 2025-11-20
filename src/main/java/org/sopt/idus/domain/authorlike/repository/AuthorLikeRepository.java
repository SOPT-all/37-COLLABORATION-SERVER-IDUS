package org.sopt.idus.domain.authorlike.repository;

import org.sopt.idus.domain.authorlike.entity.AuthorLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorLikeRepository extends JpaRepository<AuthorLike, Long> {
    boolean existsByAuthorIdAndUserId(Long authorId, Long userId);

    void deleteByAuthorIdAndUserId(Long authorId, Long userId);
}
