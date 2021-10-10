package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            // flush -> commit, query

            em.flush();

            // 결과 : 0
            // dbconn.executeQuery("select * from member");

            for (Member member1 : resultList) {
                System.out.println("member1 = " + member1);
            }

            tx.commit();

            Team team = new Team();
            team.setName("TeamA");
            // 쿼리가 한번 더 나감
            team.getMembers().add(member);
            em.persist(team);


            member.setTeamId(team.getId());
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            //List<Member> members = findMember.getTeam().getMember();

//            for(Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }

            tx.commit();    // flush
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
