package AtmInterface;
import java.sql.*;

public class Connection {
    java.sql.Connection c;
    Statement s;
    public Connection(){
            try{            // here we need to handle Exception because SQL is an external entity
//      to load the driver class
                Class.forName("com.mysql.cj.jdbc.Driver");
//      to create connection
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "nitin");
//      to give statement
                s = c.createStatement();        // statement is used to run query
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
}
