package com.example.demo;

import java.sql.*;
//@Configuration
public class AppTestConfiguration {
    public static void main(String[] args)throws Exception {
Connection conn = DriverManager.
    getConnection("jdbc:h2:~/test", "sa", "");
// add application code here
conn.close();

}
}