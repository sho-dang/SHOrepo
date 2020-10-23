package com.example.demo;

import java.sql.*;

import org.h2.jdbcx.JdbcConnectionPool;


//@Configuration
public class AppTestConfiguration {

   
    public static void main(String[] args)throws Exception {
         JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:mem:test","sa","");
       for(int i = 0 ; i < args.length; i++){
           Connection conn = cp.getConnection();
           conn.createStatement().execute(args[i]);
           conn.close();
       }
       cp.dispose();



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