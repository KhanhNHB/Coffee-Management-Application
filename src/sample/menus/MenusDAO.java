/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.menus;

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
public class MenusDAO {

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

    private List<MenusDTO> listInfoTable;

    public List<MenusDTO> getListInfoTable() {
        return listInfoTable;
    }

    public List<MenusDTO> loadInfoTable(String idTable) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT f.name, bi.count, f.price, f.price * bi.count [totalPrice] FROM dbo.Bills AS b, dbo.BillInfos AS bi, dbo.Foods AS f WHERE idTableFoods = ? AND status = 0 AND b.id = bi.idBills AND bi.idFoods = f.id";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, idTable);

                rs = stmt.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    int quatity = Integer.parseInt(rs.getString("count"));
                    float price = Float.parseFloat(rs.getString("price"));
                    float totalPrice = Float.parseFloat(rs.getString("totalPrice"));
                    if (this.listInfoTable == null) {
                        this.listInfoTable = new ArrayList<>();
                    }
                    MenusDTO dto = new MenusDTO(name, quatity, price, totalPrice);
                    this.listInfoTable.add(dto);
                }
            }
        } finally {
            closeConnection();;
        }
        return this.listInfoTable;
    }
}
