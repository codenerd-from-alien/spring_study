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

    @ManyToOne
    @JoinColumn(name = "TEAM_ID",insertable = false,updatable = false)
    private Team team;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

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


}
