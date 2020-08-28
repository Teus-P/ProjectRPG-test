package com.project.rpg.projectrpg.service.race;

import com.project.rpg.projectrpg.entity.RaceEntity;

import java.util.List;

public interface RaceService {

    List<RaceEntity> findAll();

    RaceEntity findById(int id);

    void save(RaceEntity race);

    void deleteById(int id);

}
