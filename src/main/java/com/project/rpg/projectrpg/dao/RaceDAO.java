package com.project.rpg.projectrpg.dao;

import com.project.rpg.projectrpg.entity.Race;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RaceDAO {

    @Transactional
    List<Race> findAll();
}
