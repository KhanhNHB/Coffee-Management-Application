/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.bills;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sample.utils.DBUtils;

/**
 *
 * @author hello
 */
public class BillsDAO {
    
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }
    
    public boolean checkBills(int idTableFoods) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT id FROM dbo.Bills WHERE idTableFoods = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, idTableFoods);
                rs = stmt.executeQuery();
                
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }
    
    public boolean updateBills(Date checkIn, Date checkOut, int idTableFoods, int status, int discount) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE dbo.Bills SET dateCheckIn = ?, dateCheckOut = ?, idTableFoods = ?, status = ?, discount = ? WHERE id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setDate(1, checkIn);
                stmt.setDate(2, checkOut);
                stmt.setInt(3, idTableFoods);
                stmt.setInt(4, status);
                stmt.setInt(5, discount);
                stmt.setInt(6, idTableFoods);
                int row = stmt.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }
    
    public boolean checkOut(Date checkOut, int idTableFoods, int discount, float totalPrice) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE dbo.Bills SET status = 1, dateCheckOut = ?, discount = ?, totalPrice = ? WHERE id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setDate(1, checkOut);
                stmt.setInt(2, discount);
                stmt.setFloat(3, totalPrice);
                stmt.setInt(4, idTableFoods);
                
                int row = stmt.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }
    
    public int getFoodCount(int idTableFood) throws SQLException, ClassNotFoundException {
        int number = 0;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT COUNT FROM dbo.BillInfos WHERE idBills = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, idTableFood);
                
                rs = stmt.executeQuery();
                
                if (rs.next()) {
                    number = rs.getInt("COUNT");
                }
            }
        } finally {
            closeConnection();
        }
        return number;
    }
    
    
}
