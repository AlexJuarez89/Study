package com.study.Study.service;

import com.study.Study.dto.ActorDTO;
import com.study.Study.dto.PaginatedResponse;
import com.study.Study.entity.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IActorService {
     List<Actor> getAllActors();
     Page<Actor> getActorPagination(Pageable pageable);
     PaginatedResponse<ActorDTO> getActorPaginationCustom(int page, int size);
}
