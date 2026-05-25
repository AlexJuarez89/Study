package com.study.Study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class FilmCategoryId implements Serializable {
    private static final long serialVersionUID = 2916484712430501906L;
    @Column(name = "film_id", nullable = false)
    private Short filmId;

    @Column(name = "category_id", nullable = false)
    private Short categoryId;


}