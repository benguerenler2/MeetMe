/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.accessors;

import javax.ejb.Local;
import model.Useraccount;

/**
 *
 * @author tcagla
 */
@Local
public interface UserBeanLocal {

    void addUser(Useraccount user);

    Useraccount getUser(int id);
    
    Useraccount getUserUsername(String username);

    Useraccount getUserEmail(String username);
    
}
