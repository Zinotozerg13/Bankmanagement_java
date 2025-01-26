package bank_management;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conn {
    PreparedStatement s;
    Connection c;
    Conn()
    {


        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem?user=root&password=Zinotozerg1");
            String sql = "CREATE DATABASE IF NOT EXISTS bankmanagementsystem";
            s = c.prepareStatement(sql);
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","Zinotozerg1");
            int result = s.executeUpdate();
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

}
