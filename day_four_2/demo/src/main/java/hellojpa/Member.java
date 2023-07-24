package hellojpa;


import jakarta.persistence.*;



@Entity
public class Member {
    // id 값 직접 할당 예시
    @Id @GeneratedValue
    @Column(name = "MEMBER")
    private Long id;

    @Column(name = "USERNAME")
    private String username;
//    @Column(name = "TEAM_ID")
//    private Long teamId;


    @ManyToOne
    @JoinColumn(name = "TEAM_ID")//조인하는 컬럼을 적어준다....
    private Team team;//한개에 팀에 여러사람이 관계를 가지는 관계 이므로 팀은 한개

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

    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team  = team;
    }
}
