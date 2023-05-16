package home.bruce.lesson9.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@ComponentScan("home.bruce.lesson9")
@PropertySource("classpath:tx/jdbc.properties")
@EnableTransactionManagement // 取代 tx:annotation-driven
@Configuration
public class JdbcTemplateConfig {
    @Bean
    public DataSource getDataSource(@Value("${jdbc.driver}") String driver,
                                    @Value("${jdbc.url}") String url,
                                    @Value("${jdbc.username}") String username, @Value("${jdbc.password}") String password) {
        try (DruidDataSource dataSource = new DruidDataSource()) {
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        }
    }

    @Bean
    public JdbcTemplate getJdbcTemplateConfig(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
//    @Primary // 多個資料來源，可優先使用
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
