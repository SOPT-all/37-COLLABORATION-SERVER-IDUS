package org.sopt.idus.domain.author.service;

import lombok.RequiredArgsConstructor;
import org.sopt.idus.domain.author.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorService {
    private final AuthorRepository authorRepository;
}