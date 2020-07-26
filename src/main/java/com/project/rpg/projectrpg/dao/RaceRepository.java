package com.project.rpg.projectrpg.dao;

import com.project.rpg.projectrpg.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RaceRepository extends JpaRepository<Race, Integer> {

    //:#{#properties.language}
    @Query(value = "SELECT race.id, race.name, JSON_EXTRACT(race.translation, '$.PL') AS translation " +
            "FROM race",
            nativeQuery = true)
    List<Race> findAll();
}
