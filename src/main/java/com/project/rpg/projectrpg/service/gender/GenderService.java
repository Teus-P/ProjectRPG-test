package com.project.rpg.projectrpg.service.gender;

import com.project.rpg.projectrpg.entity.GenderEntity;

import java.util.List;

public interface GenderService {

    List<GenderEntity> findAll();

    GenderEntity findById(int id);

    void save(GenderEntity gender);

    void deleteById(int id);

}
