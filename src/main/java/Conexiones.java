//@author AlejandroGpublic

import java.sql.Connection;
import java.sql.DriverManager;

class Conexiones {
 String url="jdbc:mysql://localhost:3306/biblioteca";
 String usuario="root";
 String password="";
 Connection con;

 public Connection conectar() {
     try {
         con= DriverManager.getConnection(url,usuario,password);
         System.out.println("Conexion establecida");

     } catch (Exception e) {
         throw new RuntimeException(e);
     }
     return con;
 }
}
