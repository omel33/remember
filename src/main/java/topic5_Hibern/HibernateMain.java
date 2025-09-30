package topic5_Hibern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import topic5_Hibern.dto.AppUser;

public class HibernateMain {

    public static void main(String[] args) {
        Configuration cfg=new Configuration().configure();

        try(SessionFactory sf=cfg.buildSessionFactory()){
            System.out.println("Session factory created");
            Long id;
            try(Session session=sf.openSession()){
                Transaction tx=session.beginTransaction();
                AppUser u=new AppUser("gorid@example.com", "gorid");
                session.persist(u);
                tx.commit();
                id=u.getId();
                System.out.println("Inserted user with id=" + u);
            }
            try(Session session=sf.openSession()){
                AppUser found=session.get(AppUser.class, id);
                System.out.println("Found user: " + found);
            }
            try(Session session=sf.openSession()){
                Transaction tx=session.beginTransaction();
                AppUser toUpdate=session.get(AppUser.class, id);
                toUpdate.setFullName("Hibernate User Updated");
                tx.commit();
                System.out.println("Updated user: " + toUpdate);
            }

            try(Session session=sf.openSession()){
                Transaction tx=session.beginTransaction();
                AppUser toDelete=session.get(AppUser.class, id);
                session.remove(toDelete);
                tx.commit();
                System.out.println("Deleted user: " + toDelete);
            }
        }
    }
}
