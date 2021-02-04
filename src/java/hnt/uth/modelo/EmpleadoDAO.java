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
public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;

    public Empleado validar(String user, String dni) {
        Empleado em = new Empleado();
        String sql = "SELECT * FROM empleado WHERE User=? AND Dni=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
            ps.close();
            rs.close();
            con.close();
        } catch (Exception e) {
        }
        return em;
    }

    //CRUD
    public List listar() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleado";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
            ps.close();
            rs.close();
            con.close();
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Empleado e) {
        String sql = "INSERT INTO empleado(Dni,Nombres,Telefono,Estado,User) VALUES(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getDni());
            ps.setString(2, e.getNom());
            ps.setString(3, e.getTel());
            ps.setString(4, e.getEstado());
            ps.setString(5, e.getUser());
            ps.execute();
            
            ps.close();
            con.close();
        } catch (Exception ex) {
        }
        return respuesta;
    }

    public Empleado listarId(int id){
        Empleado em = new Empleado();
        String sql = "SELECT * FROM empleado WHERE IdEmpleado="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
            }
            ps.close();
            rs.close();
            rs.close();
        } catch (Exception e) {
        }
        return em;
    }
    
    public int actualizar(Empleado e) {
        String sql = "UPDATE empleado SET Dni=? ,Nombres=?, Telefono=?, Estado=?, User=? WHERE IdEmpleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getDni());
            ps.setString(2, e.getNom());
            ps.setString(3, e.getTel());
            ps.setString(4, e.getEstado());
            ps.setString(5, e.getUser());
            ps.setInt(6, e.getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
        } catch (Exception ex) {
        }
        return respuesta;
    }

    public void delete(int id) {
        String sql = "DELETE FROM empleado WHERE IdEmpleado="+id;
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
