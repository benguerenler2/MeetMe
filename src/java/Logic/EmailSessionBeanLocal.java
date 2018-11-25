/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import javax.ejb.Local;

/**
 *
 * @author tcagla
 */
@Local
public interface EmailSessionBeanLocal {
    void sendEmail(String to, String subject, String body);
    
}
