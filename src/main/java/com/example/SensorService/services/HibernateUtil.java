package com.example.SensorService.services;

import com.example.SensorService.domain.TempSensor;
import com.example.SensorService.domain.Temp;
import com.example.SensorService.domain.TempStat;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.beans.factory.annotation.Value;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

    @Value( "${DB_URL}" )
    private String dbUrl;

    @Value( "${DB_USERNAME}" )
    private String dbUsername;

    @Value( "${DB_PASSWORD}" )
    private String dbPassword;

    public void generateSchema() {
        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class", "com.mysql.cj.jdbc.Driver");
        settings.put("hibernate.connection.url", dbUrl);
        settings.put("hibernate.connection.username", dbUsername);
        settings.put("hibernate.connection.password", dbPassword);
        settings.put("hibernate.hbm2ddl.auto", "update");
        settings.put("show_sql", "true");

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(TempSensor.class);
        metadataSources.addAnnotatedClass(Temp.class);
        metadataSources.addAnnotatedClass(TempStat.class);
        Metadata metadata = metadataSources.buildMetadata();

        SchemaExport schemaExport = new SchemaExport();
        schemaExport.setFormat(true);
        schemaExport.setOutputFile("create.sql");
        schemaExport.createOnly(EnumSet.of(TargetType.SCRIPT), metadata);
    }
}
