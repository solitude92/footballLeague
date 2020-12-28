package dao;

import entities.Player;

import javax.persistence.EntityManager;

public class PlayerDao extends AbstractJpaDao<Player, Integer> {

    public PlayerDao(EntityManager entityManager){
        super(entityManager);
    }


    public Class<Player> getEntityClass() {
        return Player.class;
    }
}
