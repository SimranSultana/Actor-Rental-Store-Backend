package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.Actor;

public interface ActorDAO {
    List<Actor> findAllActors();
    Actor findActorById(short actorId);
    Actor saveActor(Actor actor);
}
