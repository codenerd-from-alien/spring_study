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
            //Member findMember = em.find(Member.class,1L);
            //findMember.setName("HelloJPA");//jpa 가 트랜잭션 커밋하는 시점 다 채크함
            //em.persist(findMember);//1l이라는 값에 hellojpa라고 자동으로 db에 저장

//            List<Member> result =em.createQuery("select  m from Member as m",Member.class)
//                    .setFirstResult(1) //jpql은 오라클이면 오라클 mysql이면 맞게 가져옴
//                    .setMaxResults(8)
//                    .getResultList();
//            for (Member member : result){
//                System.out.println("Member.name = " + member.getName());
//            }


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}