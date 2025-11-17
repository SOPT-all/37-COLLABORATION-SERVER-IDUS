package org.sopt.idus.domain.author.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    private Integer likeCount;

    @Builder
    public Author(String name, String description, String imageUrl, Integer likeCount) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.likeCount = (likeCount == null) ? 0 : likeCount;
    }
}