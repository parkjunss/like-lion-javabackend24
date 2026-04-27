package mini.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static final Dotenv dotenv = Dotenv.load();
    private static final HikariDataSource dataSource;

    static {
        // HikariCP 설정
        HikariConfig config = new HikariConfig();
        
        // .env 파일에서 정보 로드
        config.setJdbcUrl(dotenv.get("DB_URL"));
        config.setUsername(dotenv.get("DB_USER"));
        config.setPassword(dotenv.get("DB_PW"));

        config.setMaximumPoolSize(10);        // 최대 커넥션 수
        config.setMinimumIdle(2);             // 최소 유휴 커넥션 수
        config.setIdleTimeout(30000);         // 유휴 커넥션 유지 시간 (30초)
        config.setConnectionTimeout(30000);   // 커넥션 획득 대기 시간 (30초)
        config.setMaxLifetime(1800000);       // 커넥션 최대 수명 (30분)
        
        // MySQL/MariaDB 사용 시 권장 설정
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeDataSource() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
