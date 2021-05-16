package DataBase;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.sql.SQLException;


public class UserManager extends User implements IUserDataBase {
    
    
    private final String url = "jdbc:postgresql://localhost:5432/dbakillicihaz";
    private final String user = "postgres";
    private final String password = "123456";
    
    
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("PostgreSQL veritabanına başarılı birşekilde bağlantı kuruldu.");
            }
            catch (SQLException e) {
                    System.out.println(e.getMessage());
                    }
            return conn;    
    }
    
    public UserManager() {
      
}
    
    @Override
    public boolean kullaniciDogrulama(String username, String password) {
        try {
            Connection conn = this.connect();
            if (conn != null) {
                String GetUsersSQL = "Select * From public.\"User\"";
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(GetUsersSQL);
                conn.close();
                
                boolean dogrula = false;
                while (result.next()) {
                    if (result.getString("username").equals(username) && result.getString("password").equals(password)){
                        dogrula = true;
                    }
                }
                
                if (dogrula) {
                    System.out.println("\nArayüze Hoşgeldiniz");
                    return true;
                }else {
                    System.out.println("\nArayüze giriş yapamadınız...!\n");
                    return false;
                }
            }
            else {
                System.out.println("Veritabanına baglanamadınız");
                return false;
            }
            
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}




