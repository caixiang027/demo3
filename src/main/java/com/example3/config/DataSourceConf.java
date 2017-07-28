package com.example3.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

/**
 * Created by mlamp on 2017/7/20.
 */
@Configuration
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@PropertySource(ignoreResourceNotFound = false , value = {"classpath:/config/jdbc.properties"})
@ComponentScan
@MapperScan("com.example3.mapper")
public class DataSourceConf {
    @Autowired
    private Environment env;
    private HikariDataSource dataSource;
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(env.getProperty("mysql.driverClassName"));
        config.setAutoCommit(false);
        config.setJdbcUrl(env.getProperty("mysql.ip")+env.getProperty("mysql.url"));
        config.setUsername(env.getProperty("mysql.username"));
        config.setPassword(env.getProperty("mysql.password"));
        dataSource  = new HikariDataSource(config);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setConfigLocation(resolver.getResource("classpath:/config/mybatis-config.xml"));
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
        return sessionFactory.getObject();
    }

    @PreDestroy
    public void close(){
        if (this.dataSource!= null){
            this.dataSource.close();
        }
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
