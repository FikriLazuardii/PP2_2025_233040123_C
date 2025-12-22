/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040123.modul10;

/**
 *
 * @author Fikri Lazuardi
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiDB {
    private static Connection mysqlconfig;
    
    public static Connection ConfigDB() throws SQLException {
        try {
            // URL Database (Ganti 'root' dan '' sesuai user pass database lokal Anda)
            String url = "jdbc:mysql://localhost:3306/kampus_db";
            String user = "root";
            String pass = "";
            
            // Registrasi Driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            // Buat Koneksi 
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "KOneksi Gagal: " + e.getMessage());
        }
        return mysqlconfig;
    }

    public static Connection configDB() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
