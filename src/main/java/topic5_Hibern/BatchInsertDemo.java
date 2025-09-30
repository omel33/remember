package topic5_Hibern;

import java.sql.*;
import java.util.List;

public class BatchInsertDemo {
    static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASSWORD = "root";

    public static  int[] insertUsersBatch(List<String[]> users){
        String sql = "INSERT INTO app_user(email, full_name) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql);) {

            con.setAutoCommit(false);
            for (String[] u : users){
                ps.setString(1, u[0]);
                ps.setString(2, u[1]);
                ps.addBatch();
            }
            int[] counts= ps.executeBatch();
            con.commit();
            return counts;
        }catch (BatchUpdateException bue){
            int [] counts = bue.getUpdateCounts();
            System.out.println("Batch failed, updateCounts length = " + counts.length);
            throw new RuntimeException("Batch failed: " + bue.getMessage(), bue);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        var list = List.of(
                new String[]{"first@example.com", "First User"},
                new String[]{"second@example.com", "Second User"},
                new String[]{"alice@example.com", "Alice Dup"}
        );
        insertUsersBatch( list);
    }
}
