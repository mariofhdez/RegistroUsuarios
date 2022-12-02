package modelo;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CifrarContraseña {
    public static String getHash (String txt, String hashType){
        try{
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[]array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            
            for(int i=0; i< array.length; i++){
                sb.append(Integer.toHexString((array[i]&0xff)|0x100).substring(1,3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public static String md5(String txt){
        return CifrarContraseña.getHash(txt, "MD5");
    }
    
    public static String sha1(String txt){
        return CifrarContraseña.getHash(txt, "SHA1");
    }
}
