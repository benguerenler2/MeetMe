/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import javax.ejb.Local;

/**
 *
 * @author cagri
 */
@Local
public interface CryptoBeanLocal {
    String hashPassword(String password, String salt);
    String digestText(String text, String algorithm);
    String saltGenerator();
}
