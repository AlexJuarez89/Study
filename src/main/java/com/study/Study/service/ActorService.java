package com.study.Study.service;

import com.study.Study.dto.ActorDTO;
import com.study.Study.dto.PaginatedResponse;
import com.study.Study.entity.Actor;
import com.study.Study.repository.ActorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService{
    private ActorRepository actorRepository;
    public ActorService(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }
    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Page<Actor> getActorPagination(Pageable pageable){
        return actorRepository.findAll(pageable);
    }

    @Override
    public PaginatedResponse<ActorDTO> getActorPaginationCustom(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Actor> actorPage = actorRepository.findAll(pageable);
        
        List<ActorDTO> actorDTOs = actorPage.getContent().stream()
                .map(actor -> ActorDTO.builder()
                        .id(actor.getId())
                        .firstName(actor.getFirstName())
                        .lastName(actor.getLastName())
                        .actorAge(actor.getActorAge())
                        .lastUpdate(actor.getLastUpdate())
                        .build())
                .collect(Collectors.toList());
        
        return PaginatedResponse.<ActorDTO>builder()
                .page(actorPage.getNumber() + 1)
                .per_page(actorPage.getSize())
                .total(actorPage.getTotalElements())
                .total_pages(actorPage.getTotalPages())
                .data(actorDTOs)
                .build();
    }
}
