package hei.school.ekaly.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DbConfig {
    @Bean
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                System.getenv("url"),
                System.getenv("username"),
                System.getenv("password")
        );
        return connection;
    }
}
