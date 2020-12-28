package dao;

import entities.Coach;

import javax.persistence.EntityManager;

public class CoachDao extends AbstractJpaDao<Coach, Integer> {

    public CoachDao(EntityManager entityManager) {
        super(entityManager);
    }

    public Class<Coach> getEntityClass() {
        return Coach.class;
    }
}
