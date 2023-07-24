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

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            //엔티티 매니저에게 해당 멤버 클래스 객체의 아이디를 반환 해달라 요청
            Member findMember = em.find(Member.class,member.getId());
            //Member 타입의 List 객체를 생성한다. 해당 멤버 객체의 팀을 찾고
            List<Member> members = findMember.getTeam().getMembers();
            //해당 멤버의 팀의 멤버를 다 가져오는 코드

            for (Member m : members){
                System.out.println("m = " + m.getUsername());
            }

            tx.commit();//트랜잭션 발생시 뒤에 쿼리가 날라감
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}