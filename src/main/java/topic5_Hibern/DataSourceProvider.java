package topic5_Hibern;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class DataSourceProvider {
    private static HikariDataSource ds;

    public static DataSource get() {
        if (ds == null) {
            Properties p = new Properties();
            try (var in = DataSourceProvider.class.getResourceAsStream("/application.properties")){
                p.load(in);

            }catch (Exception e){
                throw new RuntimeException(e);
            }
            HikariConfig cfg = new HikariConfig();
            cfg.setJdbcUrl(p.getProperty("db.url"));        // jdbc:postgresql://localhost:5432/demo?reWriteBatchedInserts=true
            cfg.setUsername(p.getProperty("db.user"));
            cfg.setPassword(p.getProperty("db.password"));
            cfg.setMaximumPoolSize(Integer.parseInt(p.getProperty("db.pool.size", "10")));
            cfg.setMinimumIdle(1);
            cfg.setConnectionTimeout(10_000);
            ds = new HikariDataSource(cfg);
        }
        return ds;
    }
}
