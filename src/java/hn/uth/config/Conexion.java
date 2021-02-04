/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Buddys
 */
public class Conexion {

    Connection con;
    private static final String URL = "jdbc:mysql://localhost:3306/bd_ventas";
    private static final String USER = "root";
    private static final String PASS = "";


    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
        }
        return con;
    } 
}
