package Konek;
import java.sql.Connection;
import java.sql.DriverManager;
public class koneksi {
    private static Connection con;
    public static Connection getCon(){
        if (con == null) {
            try{
                String url = "jdbc:mysql://localhost/paszakky";
                String username = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = DriverManager.getConnection(url, username, password);
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return con;
    }
}
