package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // Jpa가 이건 내가 관리해야되겠다
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name="TEAM_ID")
    private Long teamId;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
