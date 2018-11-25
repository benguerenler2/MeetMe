/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.accessors;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Useraccount;

/**
 *
 * @author tcagla
 */
@Stateless
public class UserBean implements UserBeanLocal {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addUser(Useraccount user) {
        em.persist(user);
    }

    @Override
    public Useraccount getUser(int id)
    {
        return em.find(Useraccount.class, id);
    }
    
    @Override
    public Useraccount getUserUsername(String username){
        List<Object> results = em.createQuery(
        "SELECT e FROM Useraccount e WHERE e.username= :username").setParameter("username", username).getResultList();
        if(results.size() == 0)
        {
            System.err.println("No users with name "+username);
            return null;
        }
        else
        {
            System.err.println("users with name "+username);
            return (Useraccount)results.get(0);
        }
    }
    
    @Override
    public Useraccount getUserEmail(String username){
        List<Object> results = em.createQuery(
                "SELECT e FROM Useraccount e WHERE e.email= :username").setParameter("username", username).getResultList();
        if(results.size() == 0)
        {
            System.err.println("No users with email: "+username);
            return null;
        }
        else
        {
            System.err.println("users with email: "+username);
            return (Useraccount)results.get(0);
        }
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
