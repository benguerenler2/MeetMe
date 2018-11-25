/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import javax.ejb.Local;
import model.Activesession;
import model.Useraccount;

/**
 *
 * @author tcagla
 */
@Local
public interface SessionControlBeanLocal {

    String addSession(Useraccount user);
    void removeSession(Activesession user);
    Activesession findSession(String sessionID);
}
