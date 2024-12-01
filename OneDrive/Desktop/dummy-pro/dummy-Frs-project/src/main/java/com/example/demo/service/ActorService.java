package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ActorDto;
import com.example.demo.entity.Actor;

public interface ActorService {
    List<Actor> getAllActors();
    Actor getActorById(short actorId);
    Actor saveActor(Actor actor); 
    //Used for both saving new and updating existing actors
    Actor updateActor(short actorId, ActorDto actorDto);
}

