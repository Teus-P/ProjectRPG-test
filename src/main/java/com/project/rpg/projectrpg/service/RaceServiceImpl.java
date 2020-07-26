package com.project.rpg.projectrpg.service;

import com.project.rpg.projectrpg.dao.RaceDAO;
import com.project.rpg.projectrpg.dao.RaceRepository;
import com.project.rpg.projectrpg.entity.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RaceServiceImpl implements RaceService{

    private RaceRepository raceRepository;
    private RaceDAO raceDAO;

    @Value("${properties.language}")
    private String language;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository, RaceDAO raceDAO){
        this.raceRepository = raceRepository;
        this.raceDAO = raceDAO;
    }

    @Override
    @Transactional
    public List<Race> findAll() {
//        return raceRepository.findAll();
        return raceDAO.findAll();
    }

    @Override
    public Race findById(int id) {
        Optional<Race> result = raceRepository.findById(id);

        Race race;

        if(result.isPresent()){
            race = result.get();
        }
        else {
            throw new RuntimeException("Didn't find race id - " + id);
        }

        return race;
    }

    @Override
    public void save(Race race) {
        raceRepository.save(race);
    }

    @Override
    public void deleteById(int id) {
        raceRepository.deleteById(id);
    }
}
