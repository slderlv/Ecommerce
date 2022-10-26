package Assets;

import java.util.Base64;

public class CryptoService {
    private static CryptoService service = null;

    private CryptoService(){}
	static public CryptoService getCryptoService() {
        if (service == null) {
            service = new CryptoService();
        }
        return service;
    }

    public String encodePassword(String password){
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public String decodePassword(String encrpytedPassword){
        byte[] decodedBytes = Base64.getDecoder().decode(encrpytedPassword);
        return new String(decodedBytes);
    }
}
