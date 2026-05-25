package com.study.Study.contoller;

import com.study.Study.dto.ActorDTO;
import com.study.Study.dto.PaginatedResponse;
import com.study.Study.entity.Actor;
import com.study.Study.service.ActorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("api/actors")
public class ActorController {

    private final ActorService actorService;
    public ActorController(ActorService actorService){
        this.actorService = actorService;

    }
    @GetMapping()
    public ResponseEntity<List<Actor>> getAllActors(){
        return ResponseEntity.ok(actorService.getAllActors());
    }

    @GetMapping("/health")
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok("Hola Mundo");
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Actor>> getActorPagination(@RequestParam(defaultValue = "0") int page){
        Pageable pagintation  = PageRequest.of(page, 10);
        return ResponseEntity.ok(actorService.getActorPagination(pagintation));
    }

    @GetMapping("/pagination-custom")
    public ResponseEntity<PaginatedResponse<ActorDTO>> getActorPaginationCustom(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(actorService.getActorPaginationCustom(page, size));
    }

}
