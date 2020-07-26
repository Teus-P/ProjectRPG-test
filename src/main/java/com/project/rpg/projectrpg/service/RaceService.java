package com.project.rpg.projectrpg.service;

import com.project.rpg.projectrpg.entity.Race;

import java.util.List;

public interface RaceService {

    List<Race> findAll();

    Race findById(int id);

    void save(Race race);

    void deleteById(int id);

}
