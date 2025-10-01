package topic5_Hibern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import topic5_Hibern.model.AppUser;
import topic5_Hibern.model.CustomerOrder;

import java.util.List;


public class HibernateMain_Relations {

    public static void main(String[] args) {
        Configuration cfg=new Configuration().configure()
                .addAnnotatedClass(AppUser.class)
                .addAnnotatedClass(CustomerOrder.class);

        try ( SessionFactory sf=cfg.buildSessionFactory()){
            Long userId;
            try(Session s=sf.openSession()){
                Transaction tx=s.beginTransaction();
                AppUser u=new AppUser("rel@example.com", "Relations Demo");
                CustomerOrder o1=new CustomerOrder();
                o1.setStatus(CustomerOrder.Status.PAID);
                o1.setAmount(new java.math.BigDecimal("149.90"));

                CustomerOrder o2=new CustomerOrder();
                o2.setStatus(CustomerOrder.Status.NEW);
                o2.setAmount(new java.math.BigDecimal("29.99"));

                u.addOrder(o1);
                u.addOrder(o2);

                s.persist(u);
                tx.commit();
                userId=u.getId();
                System.out.println("Inserted user with id=" + userId);
            }
            try (Session s=sf.openSession()){
                List<CustomerOrder> list=s.createQuery("select o from CustomerOrder o order by o.id", CustomerOrder.class)
                        .getResultList();
                for(CustomerOrder o:list){
                    String email=o.getUser().getEmail();
                    System.out.println(o.getId() + " :: " + email + " :: " + o.getStatus());
                }

            }
            try (Session s=sf.openSession()){
                List<CustomerOrder> list=s.createQuery("select o from CustomerOrder o"+"join fetch o.user u"+
                        "order by o.id", CustomerOrder.class).getResultList();

                for (CustomerOrder o:list){
                    System.out.println("[FETCHED] " + o.getId() + " :: " + o.getUser().getEmail());
                }
            }
            try (Session s=sf.openSession()){
                Transaction tx=s.beginTransaction();
                AppUser u=s.get(AppUser.class, userId);
                CustomerOrder toRemove=u.getOrders().get(0);
                u.removeOrder(toRemove);
                tx.commit();
                System.out.println("Removed order with id=" + toRemove.getId());
            }
            try (Session s=sf.openSession()){
                List<CustomerOrder> paid=s.createQuery("select o from CustomerOrder o " +
                        "where o.user.id = :uid and o.status = :st " +
                        "order by o.createdAt desc", CustomerOrder.class)
                        .setParameter("uid", userId)
                        .setParameter("st", CustomerOrder.Status.PAID)
                        .getResultList();
                System.out.println("PAID count = " + paid.size());
            }
        }

    }
}
