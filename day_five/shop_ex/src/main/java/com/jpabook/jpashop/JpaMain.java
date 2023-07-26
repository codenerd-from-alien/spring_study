package com.jpabook.jpashop;
import com.jpabook.jpashop.domain.Order;
import com.jpabook.jpashop.domain.OrderItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

  //          order.addOrderItem(new OrderItem());
            tx.commit();//트랜잭션 발생시 뒤에 쿼리가 날라감
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}