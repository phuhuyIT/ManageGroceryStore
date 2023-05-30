package DAO;

import DatabaseConnection.ConnectionFactory;
import Model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
    private Connection connection;

    // Constructor to initialize the DAO with a database connection
    public RoleDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // Method to insert a new role into the database
    public void insertRole(Role role) throws SQLException {
        String sql = "INSERT INTO role (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, role.getName());
            statement.executeUpdate();
        }
    }

    // Method to retrieve all roles from the database
    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT id, roleName FROM role";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("roleName");
                Role role = new Role(id, name);
                roles.add(role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }

    // Method to update an existing role in the database
    public void updateRole(Role role) throws SQLException {
        String sql = "UPDATE role SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, role.getName());
            statement.setInt(2, role.getId());
            statement.executeUpdate();
        }
    }

    // Method to delete a role from the database
    public void deleteRole(int roleId) throws SQLException {
        String sql = "DELETE FROM role WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roleId);
            statement.executeUpdate();
        }
    }
}

