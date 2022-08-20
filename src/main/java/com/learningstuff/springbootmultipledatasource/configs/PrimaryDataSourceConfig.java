package com.learningstuff.springbootmultipledatasource.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
                "com.learningstuff.springbootmultipledatasource.repositories.primary",
                "com.learningstuff.springbootmultipledatasource.models.primary"
        },
        entityManagerFactoryRef = "primaryDataSourceEntityManagerFactory",
        transactionManagerRef = "primaryDataSourceTransactionManager"
)
public class PrimaryDataSourceConfig {

    /* Primary Data Source */
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource primaryDataSource() {
        return primaryDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    /* JPA Config */
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean primaryDataSourceEntityManagerFactory(
            @Qualifier(value = "primaryDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder,
            JpaProperties jpaProperties
    ) {

        return builder
                .dataSource(dataSource)
                .packages(
                        "com.learningstuff.springbootmultipledatasource.repositories.primary",
                        "com.learningstuff.springbootmultipledatasource.models.primary"
                )
                .properties(jpaProperties.getProperties())
                .build();

    }

    @Primary
    @Bean
    public PlatformTransactionManager primaryDataSourceTransactionManager(
            @Qualifier("primaryDataSourceEntityManagerFactory") LocalContainerEntityManagerFactoryBean managerFactoryBean
    ) {
        return new JpaTransactionManager(Objects.requireNonNull(managerFactoryBean.getObject()));
    }

    /* JDBC Template */
    @Primary
    @Bean
    public JdbcTemplate primaryDataSourceJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
