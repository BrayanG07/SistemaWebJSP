/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnt.uth.modelo;

import hn.uth.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Buddys
 */
public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;

    public Cliente buscar(String dni) {
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE Dni=" + dni;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdCliente(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return c;
    }

    //CRUD
    public List listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
                lista.add(c);
            }
            ps.close();
            rs.close();
            con.close();
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Cliente c) {
        String sql = "INSERT INTO cliente(Dni,Nombres,Direccion,Estado) VALUES(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNombres());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getEstado());
            ps.execute();

            ps.close();
            con.close();
        } catch (Exception ex) {
        }
        return respuesta;
    }

    public Cliente listarId(int id) {
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setDni(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
            ps.close();
            rs.close();
            rs.close();
        } catch (Exception e) {
        }
        return c;
    }

    public int actualizar(Cliente c) {
        String sql = "UPDATE cliente SET Dni=? ,Nombres=?, Direccion=?, Estado=? WHERE IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNombres());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getEstado());
            ps.setInt(5, c.getIdCliente());
            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (Exception ex) {
        }
        return respuesta;
    }

    public void delete(int id) {
        String sql = "DELETE FROM cliente WHERE IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (Exception e) {
        }
    }
}
