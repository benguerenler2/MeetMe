/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import model.Useraccount;

/**
 *
 * @author cagri
 */
@Stateless
public class AuthBean implements AuthBeanLocal {
    @Inject
    private CryptoBeanLocal crypto;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public boolean checkUser(String password, Useraccount temp){
        String salt = temp.getSalt();//crypto.saltGenerator().trim();
        String hash = crypto.hashPassword(password, salt);
        if(hash.equals(temp.getPassword()))
        {
          //  System.err.println("uid: "+temp.getUid()+"\nuname: "+temp.getUname());
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    @Override
    public Useraccount processUser(String username, String firstname, String lastname, String email, String password)
    {
        String salt = crypto.saltGenerator().trim();
        String hash = crypto.hashPassword(password, salt);
        if(hash != null)
        {
            
        Useraccount temp = new Useraccount();
        temp.setName(firstname);
        temp.setLastname(lastname);
        temp.setUsername(username);
        temp.setEmail(email);
        temp.setPassword(hash);
        temp.setSalt(salt);
            
            return temp;
        }
        return null;
    }
    
    
}
