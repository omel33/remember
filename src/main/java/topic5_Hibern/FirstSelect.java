package topic5_Hibern;

import java.sql.*;

public class FirstSelect {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "root";
        String sql = """
    SELECT id, email, full_name, created_at
    FROM app_user
    ORDER BY id
    """;

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String email = rs.getString("email");
                String name = rs.getString("full_name");
                Timestamp created = rs.getTimestamp("created_at");
                System.out.printf("%d | %s | %s | %s%n", id, email, name, created);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage()
                    + " sqlstate=" + e.getSQLState()
                    + " code=" + e.getErrorCode());
        }
    }
    }

