package com.project.rpg.projectrpg.dao;

import com.project.rpg.projectrpg.entity.EntityTemplate;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class DaoTemplate {

    //TODO: change translation alert to message from messages.properties
    protected List<? extends EntityTemplate> checkTranslation(List<? extends EntityTemplate> list, String language){

        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", new Locale(language));
        String message = resourceBundle.getString("translationNotAvailable");

        list.forEach(o -> {
            if(o.getTranslation() == null){
                o.setTranslation(message);
            }
        });

        return list;
    }

}
