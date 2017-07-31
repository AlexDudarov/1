package gmail.alexdudarkov.sportshop.service;

import gmail.alexdudarkov.sportshop.HibernateUtil;
import gmail.alexdudarkov.sportshop.dao.GoodDaoImpl;
import gmail.alexdudarkov.sportshop.dao.UserDaoImpl;
import gmail.alexdudarkov.sportshop.model.Good;
import gmail.alexdudarkov.sportshop.model.Role;
import gmail.alexdudarkov.sportshop.model.User;
import gmail.alexdudarkov.sportshop.model.UserInformation;
import gmail.alexdudarkov.sportshop.service.model.BrandGoodDTO;
import gmail.alexdudarkov.sportshop.service.model.GoodDTO;
import gmail.alexdudarkov.sportshop.service.model.TypeGoodDTO;
import org.hibernate.Session;
import org.hibernate.context.internal.ManagedSessionContext;


public class Main {
    public static void main(String[] args) {
      /*  User u=new User();
        u.setLogin("user");
        u.setPassword("user");
        u.setRole(Role.USER);
        UserInformation ui=new UserInformation();
        u.setUserInformation(ui);
        ui.setUser(u);
*/
       // Session session = HibernateUtil.getSessionFactory().openSession();
      // ManagedSessionContext.bind(session);
        //session.beginTransaction();
        BrandGoodDTO b=BrandGoodDTO.newBuilder().id(1L).build();
        TypeGoodDTO t=TypeGoodDTO.newBuilder().id(1L).build();
        GoodDTO g=GoodDTO.newBuilder().availability(true).brandGoodDto(b).typeGoodDto(t).build();

        GoodDaoImpl us = new GoodDaoImpl();
        us.openCurrentSessionWithTransaction();
       // us.save(u);
        BrandGoodServiceImpl.convertDtoIntoDao(b);
        TypeGoodServiceImpl.convertDtoIntoDao(t);
        Good g1=new Good();
        g1.setAvailability(g.getAvailability());
        g1.setBrandGood(BrandGoodServiceImpl.convertDtoIntoDao(b));
        g1.setTypeGood(TypeGoodServiceImpl.convertDtoIntoDao(t));
        us.save(g1);
        us.closeCurrentSessionWithTransaction();
        //session.getTransaction().commit();
     //  System.out.println(ManagedSessionContext.hasBind(HibernateUtil.getSessionFactory()));
       // ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
      //  session.close();
       // System.out.println(ManagedSessionContext.hasBind(HibernateUtil.getSessionFactory()));
    }
}
