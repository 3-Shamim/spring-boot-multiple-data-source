package com.learningstuff.springbootmultipledatasource.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {
                "com.learningstuff.springbootmultipledatasource.repositories.source_one",
                "com.learningstuff.springbootmultipledatasource.models.source_one"
        },
        entityManagerFactoryRef = "dataSourceOneEntityManagerFactory",
        transactionManagerRef = "dataSourceOneTransactionManager"
)
public class DataSourceOneConfig {

    @Bean
    @ConfigurationProperties("spring.datasource-one")
    public DataSourceProperties dataSourceOneProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSourceOne() {
        return dataSourceOneProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    /* JPA Config */
    @Bean
    public LocalContainerEntityManagerFactoryBean dataSourceOneEntityManagerFactory(
            @Qualifier(value = "dataSourceOne") DataSource dataSource,
            EntityManagerFactoryBuilder builder,
            JpaProperties jpaProperties
    ) {

        return builder
                .dataSource(dataSource)
                .packages(
                        "com.learningstuff.springbootmultipledatasource.repositories.source_one",
                        "com.learningstuff.springbootmultipledatasource.models.source_one"
                )
                .properties(jpaProperties.getProperties())
                .build();

    }

    @Bean
    public PlatformTransactionManager dataSourceOneTransactionManager(
            @Qualifier("dataSourceOneEntityManagerFactory") LocalContainerEntityManagerFactoryBean managerFactoryBean
    ) {
        return new JpaTransactionManager(Objects.requireNonNull(managerFactoryBean.getObject()));
    }

    /* JDBC Template */
    @Bean
    public JdbcTemplate dataSourceOneJdbcTemplate(@Qualifier("dataSourceOne") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}
