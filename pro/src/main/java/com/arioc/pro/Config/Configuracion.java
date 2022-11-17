package com.arioc.pro.Config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class Configuracion {

    @Value("${usr}")
    String usuario;
    @Value("${cls}")
    String clave;

    @Bean
    public static DataSource getDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:sqlserver://192.168.10.136;encrypt=true;databaseName=infoPer;trustserverCertificarte=true");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("sqlserver");
        return dataSourceBuilder.build();
    }
}
