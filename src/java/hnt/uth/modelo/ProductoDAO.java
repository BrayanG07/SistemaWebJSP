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
public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;

    
    
    
    //CRUD
    public List listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                lista.add(p);
            }
            ps.close();
            rs.close();
            con.close();
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Producto p) {
        String sql = "INSERT INTO producto(Nombres,Precio,Stock,Estado) VALUES(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.execute();

            ps.close();
            con.close();
        } catch (Exception ex) {
        }
        return respuesta;
    }

    public Producto listarId(int id) {
        Producto c = new Producto();
        String sql = "SELECT * FROM producto WHERE IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setNombre(rs.getString(2));
                c.setPrecio(rs.getDouble(3));
                c.setStock(rs.getInt(4));
                c.setEstado(rs.getString(5));
            }
            ps.close();
            rs.close();
            rs.close();
        } catch (Exception e) {
        }
        return c;
    }

    public int actualizar(Producto p) {
        String sql = "UPDATE producto SET Nombres=?, Precio=?, Stock=?, Estado=? WHERE IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getIdProducto());
            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (Exception ex) {
        }
        return respuesta;
    }

    public void delete(int id) {
        String sql = "DELETE FROM producto WHERE IdProducto=" + id;
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
