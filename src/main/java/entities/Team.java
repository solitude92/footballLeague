package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String city;

    @OneToMany(mappedBy = "team")
    private Set<Player> players;

    @OneToOne(mappedBy = "team")
    private Coach coach;

    @ManyToMany
    @JoinTable(
            name = "Team_Match",
            joinColumns = @JoinColumn(name = "fk_Team_Id"),
            inverseJoinColumns = @JoinColumn(name = "fk_Match_Id")
    )
    private Set<Matches> matches;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Fk_Player")
    private Stadium stadium;

    @OneToMany(mappedBy = "team")
    private Set<MatchEvent> matchEvent;

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set<Matches> getMatches() {
        return matches;
    }

    public void setMatches(Set<Matches> matches) {
        this.matches = matches;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Set<MatchEvent> getMatchEvent() {
        return matchEvent;
    }

    public void setMatchEvent(Set<MatchEvent> matchEvent) {
        this.matchEvent = matchEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
