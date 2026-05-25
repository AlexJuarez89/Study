package com.study.Study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "actor", schema = "public", indexes = {@Index(name = "idx_actor_last_name",
        columnList = "last_name")})
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_id_gen")
    @SequenceGenerator(name = "actor_id_gen", sequenceName = "actor_actor_id_seq", allocationSize = 1)
    @Column(name = "actor_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @Column(name = "actor_age", nullable = false)
    private Integer actorAge;

}