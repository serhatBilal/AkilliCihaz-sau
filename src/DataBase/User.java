
package DataBase;


public class User {
    
    private String _kullanici_Adi;
    private String _parola;
    
    public String getKullaniciAdi() {
        return _kullanici_Adi;
    }
    
    public void SetKullaniciAdi(String username) {
        _kullanici_Adi = username; 
    }
    
    public String getParola() {
        return _parola;
    }
    
    public void SetParola(String password) {
        _parola = password; 
    }
    
    
    public User() {
        _kullanici_Adi = ""; _parola = "";
    }
    
    
}
