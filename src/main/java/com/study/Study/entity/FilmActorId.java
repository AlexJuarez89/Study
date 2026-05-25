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
public class FilmActorId implements Serializable {
    private static final long serialVersionUID = 3310126636981795802L;
    @Column(name = "actor_id", nullable = false)
    private Short actorId;

    @Column(name = "film_id", nullable = false)
    private Short filmId;


}