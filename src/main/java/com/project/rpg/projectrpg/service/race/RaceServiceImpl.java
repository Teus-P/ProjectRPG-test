package com.project.rpg.projectrpg.service.race;

import com.project.rpg.projectrpg.dao.race.RaceDAO;
import com.project.rpg.projectrpg.dao.race.RaceRepository;
import com.project.rpg.projectrpg.entity.RaceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RaceServiceImpl implements RaceService {


    private RaceRepository raceRepository;
    private RaceDAO raceDAO;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository, RaceDAO raceDAO){
        this.raceRepository = raceRepository;
        this.raceDAO = raceDAO;
    }

    @Override
    @Transactional
    public List<RaceEntity> findAll() {
        return raceDAO.findAll();
    }

    @Override
    public RaceEntity findById(int id) {
        Optional<RaceEntity> result = raceRepository.findById(id);

        RaceEntity race;

        if(result.isPresent()){
            race = result.get();
        }
        else {
            throw new RuntimeException("Didn't find race id - " + id);
        }

        return race;
    }

    @Override
    public void save(RaceEntity race) {
        raceRepository.save(race);
    }

    @Override
    public void deleteById(int id) {
        raceRepository.deleteById(id);
    }
}
