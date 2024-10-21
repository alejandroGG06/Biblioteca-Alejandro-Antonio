package org.example;

//Antonio Barahona Moreno

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOAutor {

    private Conexiones conexionbbdd;
    public DAOAutor() {
            conexionbbdd = new Conexiones();
        }

        public void InsertarAutor(Autor autor) {
            String sql = "INSERT INTO autor (id,nombre) VALUES(?,?)";

            try {
                Connection con= conexionbbdd.conectar();
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1,autor.id);
                ps.setString(2,autor.nombre);
                ps.executeUpdate();
                System.out.println("Se ha agregado el Autor");

            }catch (Exception e) {
                System.out.println(e);
            }
        }
        public List<Autor> listar(){

            String sql = "SELECT * FROM autor";
            List<Autor> lista = new ArrayList<Autor>();

            try {
                Connection con= conexionbbdd.conectar();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    Autor autor= new Autor(id,nombre);
                    lista.add(autor);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return lista;
        }

        public void updateable(Autor autor) {
            String sql = "UPDATE autor SET nombre=? WHERE id=?";
            try {
                Connection con= conexionbbdd.conectar();
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,autor.nombre);
                ps.setInt(2,autor.id);
                ps.executeUpdate();

                System.out.println("Se ha actualizado el autor");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        public void Delet(int id){
            String sql = "DELETE FROM autor WHERE id = ?";
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

