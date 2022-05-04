package com.sproject.spring_boot_web_prj.repositorys;

import com.sproject.spring_boot_web_prj.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepository{
    @Autowired
    SessionFactoryUtils sessionFactoryUtils;

    public User userByLoginPassword (String login, String password){
        Integer pass = password.hashCode();
        try(Session session = sessionFactoryUtils.getSession()) {
            TypedQuery<User> query = session.createQuery("SELECT u from User u where u.login=:ulogin",User.class);
            List<User> user = (List<User>) query.setParameter("ulogin", login).getResultList();
            if (user.size()==0){
            return null;
            }
            if (user.get(0).getPassword().equals(pass)){
                return  user.get(0);
            }
            else
              return null;
        }
    }

}
