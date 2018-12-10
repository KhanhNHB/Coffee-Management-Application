/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.foods.category;

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
public class FoodCategoryDAO {

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

    private List<FoodCategoryDTO> listFoodCategory;

    public List<FoodCategoryDTO> getListFoodCategory() {
        return listFoodCategory;
    }

    public List<FoodCategoryDTO> loadListCategory() throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT id, name FROM dbo.FoodCategory";
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");

                    if (this.listFoodCategory == null) {
                        this.listFoodCategory = new ArrayList<>();
                    }
                    FoodCategoryDTO dto = new FoodCategoryDTO(id, name);
                    this.listFoodCategory.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return this.listFoodCategory;
    }

    public boolean updateCategory(String categoryId, String categoryName) throws SQLException, ClassNotFoundException { 
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE dbo.FoodCategory SET name = ? WHERE id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, categoryName);
                stmt.setString(2, categoryId);
                
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

    public boolean insertCategory(String categoryId, String categoryName) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO dbo.FoodCategory(id, name) VALUES(?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, categoryId);
                stmt.setString(2, categoryName);

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

    public boolean deleteCategory(String categoryId) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "DELETE dbo.FoodCategory WHERE id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, categoryId);

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
