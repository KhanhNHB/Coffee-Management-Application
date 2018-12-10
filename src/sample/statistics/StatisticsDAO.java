/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.statistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author hello
 */
public class StatisticsDAO {

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

    private List<StatisticsDTO> listStatistics;

    public List<StatisticsDTO> getListStatistics() {
        return listStatistics;
    }

    public List<StatisticsDTO> loadStatistics(java.sql.Date dateIn, java.sql.Date dateOut) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "EXEC dbo.USP_StatisticsList @dateCheckIn = ?, @dateCheckOut = ?";
                stmt = con.prepareStatement(sql);
                stmt.setDate(1, dateIn);
                stmt.setDate(2, dateOut);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String tableName = rs.getString("name");
                    java.sql.Date checkIn = rs.getDate("dateCheckIn");
                    java.sql.Date checkOut = rs.getDate("dateCheckOut");
                    int discount = rs.getInt("discount");
                    float totalPrice = rs.getFloat("totalPrice");

                    if (this.listStatistics == null) {
                        this.listStatistics = new ArrayList<>();
                    }
                    StatisticsDTO dto = new StatisticsDTO(tableName, checkIn, checkOut, discount, totalPrice);
                    this.listStatistics.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return this.listStatistics;
    }

    public boolean insertBillInfoAtStatistic(String name, java.sql.Date dateIn, java.sql.Date dateOut, int discount, float totalPrice) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO dbo.Statistic(name, dateCheckIn, dateCheckOut, discount, totalPrice) VALUES(?,?,?,?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setDate(2, dateIn);
                stmt.setDate(3, dateOut);
                stmt.setInt(4, discount);
                stmt.setFloat(5, totalPrice);

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
}
