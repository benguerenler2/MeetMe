/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Calendar;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Activesession;
import model.Useraccount;

/**
 *
 * @author tcagla
 */
@Stateless
public class SessionControlBean implements SessionControlBeanLocal {
@PersistenceContext
private EntityManager em;
@Inject
    private CryptoBeanLocal crypto;
    @Override
    public String addSession(Useraccount user) {
        Activesession session = 
                new Activesession(
                        this.generateSessionToken(
                                user.getUsername().concat(
                                        Calendar.getInstance().getTime().toString()
                                )
                        )
                        , user.getUserid());
        em.persist(session);
        
        return session.getToken();
    }
    
        @Override
    public void removeSession(Activesession user) {
        System.err.println(user.getToken());
        Activesession auth = em.getReference(Activesession.class, user.getToken());
        em.remove(auth);
    }
    
    @Override
    public Activesession findSession(String sessionID)
    {
        return em.find(Activesession.class, sessionID);
    }
    private String generateSessionToken(String text)
    {
        return crypto.digestText(text, "SHA-256");
    }
}
