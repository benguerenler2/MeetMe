/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.accessors;

import java.util.List;
import javax.ejb.Local;
import model.Gr8PollSlot;

/**
 *
 * @author tcagla
 */
@Local
public interface Gr8PollSlotBeanLocal {
    void addPollSlot(Gr8PollSlot slot);
    List<Gr8PollSlot> getByPollid(int id);
}
