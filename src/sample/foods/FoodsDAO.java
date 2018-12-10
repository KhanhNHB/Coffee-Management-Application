/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.foods;

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
public class FoodsDAO {

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

    private List<FoodsDTO> listFood;

    public List<FoodsDTO> getListFood() {
        return listFood;
    }

    public List<FoodsDTO> loadListFoodByIdFoodCategory(String idFoodCate) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT id, name, idFoodCategory, price FROM dbo.Foods WHERE idFoodCategory = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, idFoodCate);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String idFoodCategory = rs.getString("idFoodCategory");
                    float price = rs.getFloat("price");

                    if (this.listFood == null) {
                        this.listFood = new ArrayList<>();
                    }
                    FoodsDTO dto = new FoodsDTO(id, name, idFoodCategory, price);
                    this.listFood.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return this.listFood;
    }

    public List<FoodsDTO> loadListFood() throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT id, name, idFoodCategory, price FROM dbo.Foods";
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String idFoodCategory = rs.getString("idFoodCategory");
                    float price = rs.getFloat("price");

                    if (this.listFood == null) {
                        this.listFood = new ArrayList<>();
                    }
                    FoodsDTO dto = new FoodsDTO(id, name, idFoodCategory, price);
                    this.listFood.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return this.listFood;
    }

    public boolean insertFood(String name, String idFoodCategory, float price) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO dbo.Foods(name, idFoodCategory, price) VALUES(?,?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setString(2, idFoodCategory);
                stmt.setFloat(3, price);

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

    public boolean deleteFood(int id) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "DELETE dbo.Foods WHERE id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);

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

    public boolean updateFood(int id, String name, String idFoodCategory, float price) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE dbo.Foods SET name = ?, idFoodCategory = ?, price = ? WHERE id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setString(2, idFoodCategory);
                stmt.setFloat(3, price);
                stmt.setInt(4, id);

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

    public int getMaxIdFood() throws SQLException, ClassNotFoundException {
        int maxNumber = -1;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT MAX(id) as [id] FROM dbo.Foods";
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    maxNumber = rs.getInt("id");
                }
            }
        } finally {
            closeConnection();
        }
        return maxNumber;
    }

    private List<FoodsDTO> listFoodSearchByName;

    public List<FoodsDTO> getListFoodSearchByName() {
        return listFoodSearchByName;
    }
    
    public List<FoodsDTO> searchFoodsByName(String nameFood) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT id, name, idFoodCategory, price FROM dbo.Foods WHERE dbo.fuConvertToUnsign1(name) LIKE '%' + dbo.fuConvertToUnsign1(?) + '%'";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, nameFood);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String idFoodCategory = rs.getString("idFoodCategory");
                    float price = rs.getFloat("price");
                    
                    if (this.listFoodSearchByName == null) {
                        this.listFoodSearchByName = new ArrayList<>();
                    }
                    FoodsDTO dto = new FoodsDTO(id, name, idFoodCategory, price);
                    this.listFoodSearchByName.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return this.listFoodSearchByName;
    }
}
