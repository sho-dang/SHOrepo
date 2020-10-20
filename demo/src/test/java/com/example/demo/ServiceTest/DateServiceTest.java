package com.example.demo.ServiceTest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DateServiceTest implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DateServiceTest.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public void run(String... strings) throws Exception {
    
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
    
        jdbcTemplate.update("INSERT INTO customers(first_name, last_name) VALUES ('John','Woo')");
    }
}