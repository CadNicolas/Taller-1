package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    private static Connection cnx=null;
    
    public static Connection Obtener() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx= DriverManager.getConnection("jdbc:mysql://localhost/bdprueba","root","");
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    }
}
