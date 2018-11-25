/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.accessors;

import javax.ejb.Local;
import model.Gr8Poll;

/**
 *
 * @author tcagla
 */
@Local
public interface Gr8PollBeanLocal {
    Gr8Poll addPoll(Gr8Poll poll);
    Gr8Poll getByPollid(int id);
}
