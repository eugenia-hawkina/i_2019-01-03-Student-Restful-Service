package telran.ashkelon2018.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
// object goes to application context
public class DBConfig {
	@Value("${db.url}")
	String url;
	@Value("${db.user}")
	String user;
	@Value("${db.password}")
	String password;
	
//	@Bean
// with this annotation there is only one connection which closes after execution
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
//	@Bean
	public DataSource getDbcp2() {
		// data base connection pool
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public DataSource getHikariCp() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
		
	}

}
