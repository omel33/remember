package topic5_Hibern;

import java.sql.*;

public class DmlBasics {
    static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASSWORD = "root";

    static long insertUser(String email, String fullName) {
        String sql = """
                INSERT INTO app_user(email, full_name)
                VALUES (?, ?)
                RETURNING id
                """;
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, email);
            ps.setString(2, fullName);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    long id = rs.getLong("id");
                    System.out.println("Inserted user with id=" + id);
                    return id;
                }
                throw new SQLException("No id returned");


            }
        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                System.out.println("User with email " + email + " already exists");
            } else {
                System.out.println("SQL error: " + e.getMessage() +
                        " sqlstate=" + e.getSQLState());
            }
            throw new RuntimeException(e);
        }

    }
    static void printUsers(long id) {
        String sql = """
                SELECT id, email, full_name, created_at
                FROM app_user
                WHERE id = ?
                """;
                try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                     PreparedStatement ps = con.prepareStatement(sql);) {

                    ps.setLong(1, id);
                    try (ResultSet rs = ps.executeQuery()) {
                        if(rs.next()){
                            System.out.printf("User: %d | %s | %s | %s%n",
                                    rs.getLong("id"),
                                    rs.getString("email"),
                                    rs.getString("full_name"),
                                    rs.getTimestamp("created_at"));
                        }else {
                            System.out.println("User with id=" + id + " not found");
                        }
                    }
                }catch (SQLException e){
                    throw new RuntimeException(e);
                }
    }
    static int updateName(long id, String newName){
        String sql = "UPDATE app_user SET full_name = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, newName);
            ps.setLong(2, id);
            int updated = ps.executeUpdate();
            System.out.println("Updated " + updated + " rows");
            return updated;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    static int deleteUser(long id){
        String sql = "DELETE FROM app_user WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setLong(1, id);
            int deleted = ps.executeUpdate();
            System.out.println("Deleted " + deleted + " rows");
            return deleted;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {

       deleteUser(10);

    }
}

