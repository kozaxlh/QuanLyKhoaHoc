/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBConnection {

    protected Connection conn;
    protected PreparedStatement stmt;
    private String host, port, dbName, dbUser, dbPassword;

    public DBConnection() {
        this.host = "localhost";
        this.port = "3306";
        this.dbName = "quanlykhoahoc";
        this.dbUser = "root";
        this.dbPassword = "";
    }

    public void connectDB() {
        String dbPath = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
        try {
            conn = (Connection) DriverManager.getConnection(dbPath, dbUser, dbPassword);
            System.out.print("Connected");
        }
        catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public ResultSet doReadQuery(String sql) {
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
        }
        catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
}
