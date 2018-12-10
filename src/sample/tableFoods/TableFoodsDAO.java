/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tableFoods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author hello
 */
public class TableFoodsDAO {

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    public static int tableWidth = 100;
    public static int tableHeight = 100;

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

    private List<TableFoodsDTO> listTable;

    public List<TableFoodsDTO> getListTable() {
        return listTable;
    }
    
    public List<TableFoodsDTO> loadTableList() throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "EXEC dbo.USP_GetTableList";
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    int id = Integer.parseInt(rs.getString("id"));
                    String name = rs.getString("name");
                    String status = rs.getString("status");
                    
                    if (this.listTable == null) {
                        this.listTable = new ArrayList<>();
                    }
                    TableFoodsDTO dto = new TableFoodsDTO(id, name, status);
                    this.listTable.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return this.listTable;
    }
    
    public boolean updateStatusForTableAfterPay(int idTableFoods, String status) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE dbo.TableFoods SET status = ? WHERE id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, status);
                stmt.setInt(2, idTableFoods);
                
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

    public String getStatusTable(int idTable) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT status FROM dbo.TableFoods WHERE id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, idTable);
                rs = stmt.executeQuery();
                
                if (rs.next()) {
                    return rs.getString("status");
                }
            }
        } finally {
            closeConnection();
        }
        return null;
    }
}
