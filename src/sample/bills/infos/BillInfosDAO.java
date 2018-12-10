/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.bills.infos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sample.utils.DBUtils;

/**
 *
 * @author hello
 */
public class BillInfosDAO {

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

    public boolean insertBillInfo(int idBills, int idFood, int count) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "EXEC dbo.USP_InsertBillInfo @idBill = ?,  @idFood = ?, @count = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, idBills);
                stmt.setInt(2, idFood);
                stmt.setInt(3, count);
                
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
    
    public boolean deleteBillInfo(int idBills) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "DELETE dbo.BillInfos WHERE idBills = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, idBills);
                
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
    
    public void swapTable(int idTable1, int idTable2) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "EXEC dbo.USP_SwapTable @idBills1 = ?,  @idBills2 = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, idTable1);
                stmt.setInt(2, idTable2);
                
                stmt.executeUpdate();
            }
        } finally {
            closeConnection();
        }
    }
}
