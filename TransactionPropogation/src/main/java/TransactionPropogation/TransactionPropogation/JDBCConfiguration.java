package TransactionPropogation.TransactionPropogation;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

@ComponentScan
@EnableTransactionManagement
// @EnableAspectJAutoProxy
@EnableAsync

public class JDBCConfiguration {

	@Bean
	public DataSource getdatasource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/student?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public JdbcTemplate getjdbc() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getdatasource());
		return jdbcTemplate;

	}

	@Bean
	TransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);

	}

}
