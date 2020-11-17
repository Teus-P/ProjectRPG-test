package com.project.rpg.projectrpg.dao.race;

import com.project.rpg.projectrpg.dao.DaoTemplate;
import com.project.rpg.projectrpg.entity.EntityTemplate;
import com.project.rpg.projectrpg.entity.RaceEntity;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RaceDAOImpl extends DaoTemplate implements RaceDAO {

    private final EntityManager entityManager;

    @Autowired
    public RaceDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<RaceEntity> findAll(String language) {

        Session session = entityManager.unwrap(Session.class);
        session.setHibernateFlushMode(FlushMode.MANUAL);
        session.clear();

        String lang = "$." + language.toUpperCase();

        Query<RaceEntity> query = session.createNativeQuery(
                "SELECT race.id, race.name, JSON_EXTRACT(race.translation, \'" + lang + "\') AS translation " +
                        "FROM race", RaceEntity.class);

        List<? extends EntityTemplate> raceEntities = query.getResultList();
        raceEntities = checkTranslation(raceEntities, language);

        return (List<RaceEntity>)raceEntities;
    }
}
