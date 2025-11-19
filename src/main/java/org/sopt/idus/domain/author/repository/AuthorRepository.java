package org.sopt.idus.domain.author.repository;

import org.sopt.idus.domain.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}