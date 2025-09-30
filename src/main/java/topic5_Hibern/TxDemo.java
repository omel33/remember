package topic5_Hibern;

import java.sql.*;

public class TxDemo {
    static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASSWORD = "root";

    static long insertOne(Connection con, String email, String fullName) throws SQLException {
        String sql = """
            INSERT INTO app_user(email, full_name)
            VALUES (?, ?)
            RETURNING id
            """;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, fullName);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next())
                    return rs.getLong("id");
                throw new SQLException("No id returned");
            }
        }
    }
    public static void registerTwoUsersAtomically(String e1, String n1, String e2, String n2)  {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
            con.setAutoCommit(false);
            try{
                long id1 = insertOne(con, e1, n1);
                System.out.println("Inserted user with id=" + id1);
                long id2 = insertOne(con, e2, n2);
                System.out.println("Inserted user with id=" + id2);
                con.commit();
                System.out.println("Committed");
            }catch (SQLException ex){
                System.out.println("Rolling back");
                con.rollback();
                throw ex;
            }finally {
                con.setAutoCommit(true);
            }

        }catch (SQLException e){
            if ("23505".equals(e.getSQLState())){
                System.out.println("User with email " + e1 + " already exists");
            }else {
                System.err.println("SQL error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        registerTwoUsersAtomically("anna@example.com", "Anna Blue",
                "mark@example.com", "Mark Red");
        registerTwoUsersAtomically("john@example.com", "John Black",
                "alice@example.com", "Alice Again");
    }
}
