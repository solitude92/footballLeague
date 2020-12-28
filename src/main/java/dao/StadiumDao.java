package dao;

import entities.Stadium;

import javax.persistence.EntityManager;

public class StadiumDao extends AbstractJpaDao<Stadium, Integer> {

    public StadiumDao(EntityManager entityManager){
        super(entityManager);
    }


    public Class<Stadium> getEntityClass() {
        return Stadium.class;
    }
}
