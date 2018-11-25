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
import model.Gr8PollSlot;

/**
 *
 * @author tcagla
 */
@Stateless
public class Gr8PollSlotBean implements Gr8PollSlotBeanLocal {
    @PersistenceContext
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void addPollSlot(Gr8PollSlot slot) {
        em.persist(slot);
    }
    @Override
    public List<Gr8PollSlot> getByPollid(int id){
        return em.createNamedQuery("Gr8PollSlot.findByPollid", Gr8PollSlot.class).setParameter("pollid", id).getResultList();
    }
}
