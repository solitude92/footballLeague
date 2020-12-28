package entities;

import sun.util.resources.LocaleData;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Entity
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "match_date")
    private LocalDate date;

    @Column(name = "match_time")
    private LocalTime time;

    @Column
    private Integer goalTeamHost;

    @Column
    private Integer goalTeamGuest;

    @ManyToMany
    private Set<Team> teams;

    @OneToOne
    private Stadium stadium;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<MatchEvent> matchEvents;


    public LocalTime getTime() {
        return time;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Set<MatchEvent> getMatchEvents() {
        return matchEvents;
    }

    public void setMatchEvents(Set<MatchEvent> matchEvents) {
        this.matchEvents = matchEvents;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getGoalTeamHost() {
        return goalTeamHost;
    }

    public void setGoalTeamHost(Integer goalTeamHost) {
        this.goalTeamHost = goalTeamHost;
    }

    public Integer getGoalTeamGuest() {
        return goalTeamGuest;
    }

    public void setGoalTeamGuest(Integer goalTeamGuest) {
        this.goalTeamGuest = goalTeamGuest;
    }
}
