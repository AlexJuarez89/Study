package com.study.Study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ActorDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer actorAge;
    private Instant lastUpdate;
}
