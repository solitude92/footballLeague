import dao.*;
import entities.*;
import util.JpaUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Player player1 = new Player();
        player1.setFirstName("Khodad");
        player1.setLastName("Azizi");
        player1.setNationalCode("4563217890");
        player1.setPhoneNo("09195488574");
        player1.setSalary(1230.00);
        PlayerDao playerDao = new PlayerDao(entityManager);
        playerDao.save(player1);


        Player player2 = new Player();
        player2.setFirstName("Farhad");
        player2.setLastName("Majidi");
        player2.setNationalCode("5478963210");
        player2.setPhoneNo("09195587789");
        player2.setSalary(1830.00);
        playerDao.save(player2);


        Player player3 = new Player();
        player3.setFirstName("Arash");
        player3.setLastName("Borhani");
        player3.setNationalCode("54878963210");
        player3.setPhoneNo("09398745632");
        player3.setSalary(950.00);
        playerDao.save(player3);


        Team team1 = new Team();
        team1.setName("prespolis");
        team1.setCity("Tehran");
        TeamDao teamDao = new TeamDao(entityManager);
        Set<Player> teamPlayers = new HashSet<>();
        teamPlayers.add(player1);
        team1.setPlayers(teamPlayers);
        teamDao.save(team1);

        Team team2 = new Team();
        team2.setName("Esteghlal");
        team2.setCity("Tehran");
        Set<Player> teamPlayers1 = new HashSet<>();
        teamPlayers1.add(player2);
        teamPlayers1.add(player3);
        team2.setPlayers(teamPlayers1);
        teamDao.save(team2);


        Coach coach1 = new Coach();
        coach1.setFirstName("Ali");
        coach1.setLastName("Daei");
        coach1.setNationalCode("65478512390");
        coach1.setPhoneNo("09125469872");
        coach1.setSalary(1520.00);
        coach1.setTeam(team1);
        CoachDao coachDao = new CoachDao(entityManager);
        coachDao.save(coach1);

        Coach coach2 = new Coach();
        coach2.setFirstName("Berankow");
        coach2.setLastName("Witch");
        coach2.setNationalCode("984564852590");
        coach2.setPhoneNo("09125478963");
        coach2.setSalary(1020.00);
        coach2.setTeam(team2);
        coachDao.save(coach2);


        Stadium stadium = new Stadium();
        stadium.setName("Azadi");
        stadium.setCity("Teharan");
        stadium.setCapacity(10000);
        Set<Team> owner = new HashSet<>();
        owner.add(team1);
        owner.add(team2);
        stadium.setTeams(owner);
        StadiumDao stadiumDao = new StadiumDao(entityManager);
        stadiumDao.save(stadium);


        MatchEvent matchEvent1 = new MatchEvent();
        matchEvent1.setPlayer(player1);
        matchEvent1.setTeam(team1);
        matchEvent1.setGoals(2);
        matchEvent1.setInjuries("Hand broken");
        MatchEventDao matchEventDao = new MatchEventDao(entityManager);
        matchEventDao.save(matchEvent1);

        MatchEvent matchEvent2 = new MatchEvent();
        matchEvent2.setPlayer(player2);
        matchEvent2.setTeam(team2);
        matchEvent2.setGoals(2);
        matchEventDao.save(matchEvent2);


        MatchEvent matchEvent3 = new MatchEvent();
        matchEvent3.setPlayer(player3);
        matchEvent3.setTeam(team2);
        matchEvent3.setGoals(3);

        matchEventDao.save(matchEvent3);

        Matches matches1 = new Matches();
        matches1.setDate(LocalDate.of(2019, 1, 26));
        matches1.setTime(LocalTime.of(12,20));
        MatchDao matchDao = new MatchDao(entityManager);
        Set<Team> derbi = new HashSet<>();
        derbi.add(team1);//Home
        derbi.add(team2);//Away
        matches1.setTeams(derbi);
        matches1.setGoalTeamGuest(2);
        matches1.setGoalTeamHost(3);
        matches1.setStadium(stadium);
        Set<MatchEvent> matchEvents = new HashSet<>();
        matchEvents.add(matchEvent1);
        matchEvents.add(matchEvent2);
        matchEvents.add(matchEvent3);
        matches1.setMatchEvents(matchEvents);
        matchDao.save(matches1);






        entityManager.getTransaction().commit();
        entityManager.close();
        JpaUtil.shutdown();
    }
}
