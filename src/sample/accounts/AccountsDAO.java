/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.accounts;

import java.io.Serializable;
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
public class AccountsDAO implements Serializable {

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

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

    public AccountsDTO checkLogin(String user, String password) throws SQLException, ClassNotFoundException {
        AccountsDTO dto = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "EXEC dbo.USP_Login @username = ?, @password = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, user);
                stmt.setString(2, password);

                rs = stmt.executeQuery();

                while (rs.next()) {
                    String username = rs.getString("username");
                    String fullname = rs.getString("fullname");
//                    String pass = MD5.md5(rs.getString("password"));
                    String pass = rs.getString("password");
                    int type = Integer.parseInt(rs.getString("type"));

                    dto = new AccountsDTO(username, password, fullname, type);
                    return dto;
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    private List<AccountsDTO> listAccounts;

    public List<AccountsDTO> getListAccounts() {
        return listAccounts;
    }

    public List<AccountsDTO> loadAccountList() throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT username, fullname, password, type FROM dbo.Accounts";
                stmt = con.prepareStatement(sql);

                rs = stmt.executeQuery();

                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullname = rs.getString("fullname");
                    int type = Integer.parseInt(rs.getString("type"));
                    if (this.listAccounts == null) {
                        this.listAccounts = new ArrayList<>();
                    }
                    AccountsDTO dto = new AccountsDTO(username, password, fullname, type);
                    this.listAccounts.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return this.listAccounts;
    }

    public boolean updateAccounts(String username, String fullname, String password, String newPassword, int type) throws SQLException, ClassNotFoundException {
        String sql;
        int row;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                if (!newPassword.isEmpty()) {
                    sql = "UPDATE dbo.Accounts SET fullname = ?, password = ? WHERE username = ? AND password = ?";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, fullname);
                    stmt.setString(2, newPassword);
                    stmt.setString(3, username);
                    stmt.setString(4, password);

                    row = stmt.executeUpdate();

                    if (row > 0) {
                        return true;
                    }
                } else {
                    sql = "UPDATE dbo.Accounts SET fullname = ? WHERE username = ? AND password = ?";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, fullname);
                    stmt.setString(2, username);
                    stmt.setString(3, password);

                    row = stmt.executeUpdate();

                    if (row > 0) {
                        return true;
                    }
                }

            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean insertAccounts(String username, String fullname, String password, int type) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO dbo.Accounts(username, fullname, password, type) VALUES(?,?,?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, fullname);
                stmt.setString(3, password);
                stmt.setInt(4, type);

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

    public boolean deleteAccounts(String username, String password) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "DELETE dbo.Accounts WHERE username = ? AND password = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, password);

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
