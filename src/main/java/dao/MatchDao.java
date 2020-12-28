package dao;

import entities.Matches;

import javax.persistence.EntityManager;

public class MatchDao extends AbstractJpaDao<Matches, Integer> {

    public MatchDao(EntityManager entityManager){
        super(entityManager);
    }


    public Class<Matches> getEntityClass() {
        return Matches.class;
    }
}
