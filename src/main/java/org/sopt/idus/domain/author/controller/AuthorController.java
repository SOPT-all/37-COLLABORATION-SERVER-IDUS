package org.sopt.idus.domain.author.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.idus.domain.author.service.AuthorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("authors")
public class AuthorController {
    private final AuthorService authorService;
}
