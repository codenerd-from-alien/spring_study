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

            //영속
//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);//엔티티 메니저에서 영속성 컨텍스트로 차곡 차곡 저장
//            em.persist(member2);
//            System.out.println("===================================");
            //테이블의 해당 내용 바꾸는 법
//            Member member = em.find(Member.class, 160L);
//            member.setName("B");//값만 바꿔도 update 쿼리가 발생
            //jpa는 더티 checking 변경 감지 가능


//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();//쿼리가 나간 후에 tx commit 발생시 트랜잭션 발생
//            System.out.println("=====================");

//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAAAAAAA");
//            em.detach(member);//<-영속성 컨텍스로 관리 안함(준영속 상태)
//            em.clear();//<-엔티티 메니저 통제로 다지움


            Member member = new Member();
            member.setId(3L);
            member.setUsername("C");
            member.setRoleType(RoleType.GUEST);
            em.persist(member);
            tx.commit();//트랜잭션 발생시 뒤에 쿼리가 날라감
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}