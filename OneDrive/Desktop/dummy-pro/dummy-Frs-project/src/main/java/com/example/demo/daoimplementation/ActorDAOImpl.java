package com.example.demo.daoimplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.ActorDAO;
import com.example.demo.entity.Actor;
import com.example.demo.repository.ActorRepository;

@Repository
public class ActorDAOImpl implements ActorDAO {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findActorById(short actorId) {
        return actorRepository.findById(actorId).orElse(null);
    }

    @Override
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }
}
