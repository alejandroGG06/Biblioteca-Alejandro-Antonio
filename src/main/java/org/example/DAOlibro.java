package org.example;

//@author AlejandroGpublic

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class DAOlibro {
private Conexiones conexionbbdd;
public DAOlibro() {
    conexionbbdd = new Conexiones();
}

public void Insertarlibro(Libro lib) {
String sql = "INSERT INTO libro (id,titulo,isbn) VALUES(?,?,?)";

try {
    Connection con= conexionbbdd.conectar();
    PreparedStatement ps = con.prepareStatement(sql);

    ps.setInt(1,lib.id);
    ps.setString(2,lib.titulo);
    ps.setString(3,lib.isbn);
    ps.executeUpdate();
    System.out.println("Se ha agregado el libro");

}catch (Exception e) {
    System.out.println(e);
}
}
public List<Libro>listar(){

    String sql = "SELECT * FROM libro";
    List<Libro> lista = new ArrayList<Libro>();

    try {
        Connection con= conexionbbdd.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
    int id = rs.getInt("id");
    String titulo = rs.getString("titulo");
    String isbn = rs.getString("isbn");
        Libro lib= new Libro(id,titulo,isbn);
        lista.add(lib);
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    return lista;
}

    public void updateable(Libro lib) {
    String sql = "UPDATE libro SET titulo=?,isbn=? WHERE id=?";
    try {
        Connection con= conexionbbdd.conectar();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,lib.titulo);
        ps.setString(2,lib.isbn);
        ps.setInt(3,lib.id);
        ps.executeUpdate();

        System.out.println("Se ha actualizado el libro");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
    public void Delet(int id){
    String sql = "DELETE FROM libro WHERE id = ?";
    try {
        Connection con= conexionbbdd.conectar();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
        System.out.println("Se ha eliminado el libro");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
}
