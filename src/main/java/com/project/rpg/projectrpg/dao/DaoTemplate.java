package com.project.rpg.projectrpg.dao;

import com.project.rpg.projectrpg.entity.EntityTemplate;

import java.util.List;

public class DaoTemplate {

    protected List<? extends EntityTemplate> checkTranslation(List<? extends EntityTemplate> list){
        list.forEach(o -> {
            if(o.getTranslation() == null){
                o.setTranslation("Translation not available");
            }
        });

        return list;
    }

}
