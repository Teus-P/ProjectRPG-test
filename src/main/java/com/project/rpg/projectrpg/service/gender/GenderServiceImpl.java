package com.project.rpg.projectrpg.service.gender;

import com.project.rpg.projectrpg.dao.gender.GenderDAO;
import com.project.rpg.projectrpg.entity.GenderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GenderServiceImpl implements GenderService{
    
    private GenderDAO genderDAO;

    @Autowired
    public GenderServiceImpl(GenderDAO genderDAO) {
        this.genderDAO = genderDAO;
    }

    @Override
    @Transactional
    public List<GenderEntity> findAll() {
        return genderDAO.findAll();
    }

    @Override
    @Transactional
    public GenderEntity findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public void save(GenderEntity gender) {

    }

    @Override
    @Transactional
    public void deleteById(int id) {

    }
}
