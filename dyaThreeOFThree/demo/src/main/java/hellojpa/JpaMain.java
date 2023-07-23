package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

//            Team team = new Team();
//            team.setName("TeamA");
//
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);
//            //<-db 테이블 대로 연관 관계를 지으면 jpa에게 자꾸 물어 봐야함

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            Member findMember = em.find(Member.class, member.getId());

            findMember.getTeam();

            Team findTeam = findMember.getTeam();//<-위의 예제와 다르게
            //멤버 객체 자채에 TeamA를 setTeam을 넣어서 해당 맴버를 찾을 때는 해당 멤버에 id 에 해당하는 팀을 찾을 연관 관계를 만들 수 있따.
            //객체 지향 스럽게 설계가 가능하다.
            System.out.println("findTeam = "+ findTeam.getName());


            tx.commit();//트랜잭션 발생시 뒤에 쿼리가 날라감
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}