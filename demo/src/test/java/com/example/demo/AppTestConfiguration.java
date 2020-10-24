package com.example.demo;

import java.sql.*;

import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
//@Configuration
public class AppTestConfiguration implements CommandLineRunner  {
  
    
   
        public static void main(String[] args) {
            SpringApplication.run(AppTestConfiguration.class, args);
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
   



/*
 try{
            Class.forName("org.h2.Driver");
          }catch(ClassNotFoundException e){
            e.printStackTrace();
          }


       Connection con =null;
       try{
            con = DriverManager.
               getConnection("jdbc:h2:mem:test");

          }catch(SQLException e){
              e.printStackTrace();
          }finally{
             if(con != null){

                try{
                    con.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
             }
            }


*/