package com.project.rpg.projectrpg.dao;

import com.project.rpg.projectrpg.entity.Race;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RaceDAOImpl implements RaceDAO{

    private EntityManager entityManager;

    @Value("${properties.language}")
    private String language;

    @Autowired
    public RaceDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Race> findAll() {

        Session session = entityManager.unwrap(Session.class);
        Query<Race> query = session.createNativeQuery("SELECT race.id, race.name, JSON_EXTRACT(race.translation, " + language + ") AS translation FROM race", Race.class);

        return query.getResultList();
    }
}
