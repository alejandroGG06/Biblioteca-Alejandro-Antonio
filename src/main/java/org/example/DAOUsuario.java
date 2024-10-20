package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuario {
    private Conexiones conexionbbdd;
    public DAOUsuario() {
        conexionbbdd = new Conexiones();
    }

    public void InsertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (id,nombre) VALUES(?,?)";

        try {
            Connection con= conexionbbdd.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,usuario.id);
            ps.setString(2,usuario.nombre);
            ps.executeUpdate();
            System.out.println("Se ha agregado el Autor");

        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<Usuario> listar(){

        String sql = "SELECT * FROM usuario";
        List<Usuario> lista = new ArrayList<Usuario>();

        try {
            Connection con= conexionbbdd.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Usuario usuario= new Usuario(id,nombre);
                lista.add(usuario);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void updateable(Usuario usuario) {
        String sql = "UPDATE usuario SET nombre=? WHERE id=?";
        try {
            Connection con= conexionbbdd.conectar();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,usuario.nombre);
            ps.setInt(2,usuario.id);
            ps.executeUpdate();

            System.out.println("Se ha actualizado el autor");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void Delet(int id){
        String sql = "DELETE FROM usuario WHERE id = ?";
        try {
            Connection con= conexionbbdd.conectar();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Se ha eliminado el autor");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
