package com.example.demo;

import java.sql.*;


//@Configuration
public class AppTestConfiguration {

   
    public static void main(String[] args)throws Exception {

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





}
}