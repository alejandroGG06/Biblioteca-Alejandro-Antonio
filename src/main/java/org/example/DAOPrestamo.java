package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPrestamo {
    private Conexiones conexionbbdd;
    public DAOPrestamo() {
        conexionbbdd = new Conexiones();
    }

    public void InsertarPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO usuario (idPrestamo, fechaIni, fechaFin, usuarioId, libroId) VALUES(?,?,?,?,?)";

        try {
            Connection con= conexionbbdd.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,prestamo.idPrestamo);
            ps.setInt(2,prestamo.fechaInicio);
            ps.setInt(3,prestamo.fechaFin);
            ps.setInt(4, prestamo.usuarioId);
            ps.setInt(5,prestamo.libroId);
            ps.executeUpdate();
            System.out.println("Se ha agregado el Prestamo");

        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<Prestamo> listar(){

        String sql = "SELECT * FROM Prestamo";
        List<Prestamo> lista = new ArrayList<Prestamo>();

        try {
            Connection con= conexionbbdd.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idPrestamo = rs.getInt("idPrestamo");
                int fechaIni = rs.getInt("fechaIni");
                int fechaFin = rs.getInt("fechaFin");
                int idUsuario = rs.getInt("idUsuario");
                int idLibro = rs.getInt("idLibro");
                Prestamo prestamo= new Prestamo(idPrestamo,fechaIni,fechaFin,idUsuario,idLibro);
                lista.add(prestamo);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void updateable(Prestamo prestamo) {
        String sql = "UPDATE prestamo SET fechaIni=?, fechaFin=?, usuarioId, libroId=? WHERE idPrestamo=?";
        try {
            Connection con= conexionbbdd.conectar();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,prestamo.fechaInicio);
            ps.setInt(2,prestamo.fechaFin);
            ps.setInt(3,prestamo.usuarioId);
            ps.setInt(4,prestamo.libroId);
            ps.setInt(5,prestamo.idPrestamo);
            ps.executeUpdate();

            System.out.println("Se ha actualizado el prestamo");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void Delet(int id){
        String sql = "DELETE FROM prestamo WHERE idPrestamo = ?";
        try {
            Connection con= conexionbbdd.conectar();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Se ha eliminado el prestamo");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
