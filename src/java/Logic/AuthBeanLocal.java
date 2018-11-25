/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import javax.ejb.Local;
import model.Useraccount;

/**
 *
 * @author cagri
 */
@Local
public interface AuthBeanLocal {
    
    boolean checkUser(String password, Useraccount temp);
    
    Useraccount processUser(String username, String firstname, String lastname, String email, String password);
}
