package com.project.rpg.projectrpg.dao.race;

import com.project.rpg.projectrpg.entity.RaceEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RaceDAO {

    @Transactional
    List<RaceEntity> findAll();
}
