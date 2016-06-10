package modelo.Negocio;

import modelo.Datos.*;
import java.util.List;
import modelo.Clases.*;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;


public class GestorUsuario {
	
	Connect con = new Connect();
	
	public void addUsuario(String username, String mail, String password) {
		if(existsUsuario(username) == false) {
			Usuario u = new Usuario(username, mail, password);
			con.getIDao().añadirUsuario(u);
		} else {
			existeUsuarioException();
		}
	}
	
	public boolean existsUsuario(String username) {
		boolean existe;
		existe = con.getIDao().existsUsuario(username);
		return existe;
	}
	
	public Usuario getUsuario(String username) {
		Usuario u = con.getIDao().getUsuario(username);
		return u;
	}
	
	public void borrarUsuario(String username) {
		Usuario u = getUsuario(username);
		con.getIDao().borrarUsuario(u);
	}
	
	public void modificarUsuario(String username, String mail, String password) {
		Usuario u = getUsuario(username);
		u.setMail(mail);
		u.setPassword(password);
		con.getIDao().modificarUsuario(u);
	}
	
	public List<Usuario> getUsuarios() {
		List <Usuario> lista = con.getIDao().getUsuarios();
		return lista;
	}
	
	public boolean logIn(String username, String password) {
		boolean log;
		if(existsUsuario(username) == true) {
			log = true;
		} else {
			log = false;
			noExisteUsuarioException();
		}
		return log;
	}
	
	public String existeUsuarioException() {
		String mensaje = "Ya existe este usuario";
		return mensaje;
	}
	
	public String noExisteUsuarioException() {
		String mensaje = "No existe este usuario";
		return mensaje;
	}
	
	public static String cifrarPassword(String pass) {
 
        String secretKey = "materialrequirementplanningsystem"; //llave para cifrar datos
        String base64EncryptedString = "";
 
        try {
 
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
 
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = pass.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }
	
	public static String descifrarPassword(String passCifrada) throws Exception {
		 
        String secretKey = "materialrequirementplanningsystem"; //llave para cifrar datos
        String base64EncryptedString = "";
 
        try {
            byte[] message = Base64.decodeBase64(passCifrada.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
 
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
 
            byte[] plainText = decipher.doFinal(message);
 
            base64EncryptedString = new String(plainText, "UTF-8");
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }
 
}
