package com.example.demo.serviceimplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ActorDto;
import com.example.demo.entity.Actor;
import com.example.demo.repository.ActorRepository;
import com.example.demo.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actor getActorById(short actorId) {
        return actorRepository.findById(actorId).orElse(null);
    }

    @Override
    public Actor saveActor(Actor actor) {
        //In a real application, you'd likely want more robust validation here.
        if(actor.getFirst_name() == null || actor.getFirst_name().isEmpty() || actor.getLast_name() == null || actor.getLast_name().isEmpty()){
            throw new IllegalArgumentException("First and last name cannot be empty.");
        }

        return actorRepository.save(actor); //This handles both saving new and updating existing actors
    }
    
    
    
    @Override
    public Actor updateActor(short actorId, ActorDto actorDto) {
        Actor actor = actorRepository.findById(actorId).orElse(null);
        if (actor == null) {
            throw new IllegalArgumentException("Actor not found");
        }
        if(actorDto.getFirst_name() != null){
            actor.setFirst_name(actorDto.getFirst_name());
        }
        if(actorDto.getLast_name() != null){
            actor.setLast_name(actorDto.getLast_name());
        }
        return actorRepository.save(actor);
    }
}
