package com.project.rpg.projectrpg.dao.gender;

import com.project.rpg.projectrpg.entity.GenderEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GenderDAO {

    @Transactional
    List<GenderEntity> findAll();
}
