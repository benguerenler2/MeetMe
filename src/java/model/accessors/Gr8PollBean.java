/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.accessors;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import model.Gr8Poll;
import javax.persistence.EntityManager;


/**
 *
 * @author tcagla
 */
@Stateless
public class Gr8PollBean implements Gr8PollBeanLocal {
    @PersistenceContext
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Gr8Poll addPoll(Gr8Poll poll) {
        em.persist(poll);
        return poll;
    }
    @Override
    public Gr8Poll getByPollid(int id){
        return em.createNamedQuery("Gr8Poll.findByPollid", Gr8Poll.class).setParameter("pollid", id).getSingleResult();
    }
}
