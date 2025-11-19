package org.sopt.idus.domain.author.repository;

import org.sopt.idus.domain.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Modifying
    @Query("update Author a set a.likeCount = a.likeCount + 1 where a = :author")
    void increaseLikeCount(Author author);

    @Modifying
    @Query("update Author a set a.likeCount = a.likeCount - 1 where a = :author")
    void decreaseLikeCount(Author author);
}