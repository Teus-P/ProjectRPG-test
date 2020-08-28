package com.project.rpg.projectrpg.dao.gender;

import com.project.rpg.projectrpg.entity.GenderEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class GenderDAOImpl implements GenderDAO{

    EntityManager entityManager;

    @Value("${properties.language}")
    private String language;

    @Autowired
    public GenderDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<GenderEntity> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<GenderEntity> query = session.createNativeQuery("SELECT gender.id, gender.name, JSON_EXTRACT(gender.translation, " + language + ") AS translation FROM gender", GenderEntity.class);

        return query.getResultList();
    }
}
