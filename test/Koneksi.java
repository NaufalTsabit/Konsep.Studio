

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Koneksi {
    Connection con;
    public Connection getCon(){
        if (con!=null){
            return con;
        }
        else{
            try {
            //con = DriverManager.getConnection("jdbc:mysql://konsepstudio.jux.in/konsepst_studio","konsepst_studio","PoiLkj123");
            con = DriverManager.getConnection("jdbc:mysql://localhost/studio","root","");
            //JOptionPane.showMessageDialog(null, "Konesi ke Database BERHASIL");
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Konesi ke Database GAGAL");
            }
        }
        return con;
    }
}