package org.example;

//@author AlejandroGpublic

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class DAOlibroautor {
private Conexiones conexionbbdd;
public DAOlibroautor() {
    conexionbbdd = new Conexiones();
}
public void insertal(Libro_Autor libro_autor) {
    String sql = "insert into libro_autor (idLibro,idAutor) values(?,?)";

    try {
        Connection cone = conexionbbdd.conectar();
        PreparedStatement ps = cone.prepareStatement(sql);
        ps.setInt(1, libro_autor.getIdLibro());
        ps.setInt(2, libro_autor.getIdAutor());
        ps.executeUpdate();
        cone.close();
        System.out.println("Relacion creada");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public List<Libro_Autor>list(){
        String sql = "select * from libro_autor";
        List<Libro_Autor> listaLibroAutor = new ArrayList<Libro_Autor>();
        try {
            Connection cone = conexionbbdd.conectar();
            PreparedStatement ps= cone.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idLibro = rs.getInt("idLibro");
                int idAutor = rs.getInt("idAutor");
                Libro_Autor libro_autor = new Libro_Autor(idLibro, idAutor);
                listaLibroAutor.add(libro_autor);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  listaLibroAutor;
    }
    public void delet(int id){
    String sql = "delete from libro_autor where idLibro=? and idAutor=?";

    try {
        Connection cone = conexionbbdd.conectar();
        PreparedStatement ps= cone.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setInt(2, id);
        ps.executeUpdate();
        cone.close();
        System.out.println("Se elimino la relacion");
    }catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

}
