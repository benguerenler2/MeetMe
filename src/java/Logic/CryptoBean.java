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
import javax.ejb.Stateless;

/**
 *
 * @author cagri
 */
@Stateless(mappedName = "CryptoBeanLocal")
public class CryptoBean implements CryptoBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public String hashPassword(String password, String salt)
    {
        String digested = digestText(password, "SHA-256");
        if(digested != null)
        {
            digested = digestText(salt.concat(digested), "SHA-256");
        }
        return digested;
    }
    @Override
    public String digestText(String text, String algorithm)
    {
        try{
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] mdbytes = md.digest(text.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < mdbytes.length; i++) {
                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public String saltGenerator()
    {
        Random rng = new Random();
        rng.setSeed(System.currentTimeMillis());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++)
        {
            sb.append((char)(rng.nextInt(27)+97));
        }
        
        return sb.toString();
    }
}
