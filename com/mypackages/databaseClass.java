package com.mypackages;

import java.sql.*;

public class databaseClass
{
    Connection con;
    Statement stat;
    ResultSet rs;
   public databaseClass()
    {
		
        try{
			Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
               stat=con.createStatement();
           }
        catch (Exception ae) 
        {
            System.out.println("error while connecting: "+ae);
        }
    }
        //return boolean
    public Boolean checkLogin(String email,String pwd)
    {
        try {        
			 
			String sql= "select * from login where Email='"+email+"' and password='"+pwd+"'"; 	
    
            rs=stat.executeQuery(sql);
            if(rs.next())
            {
                //TRUE if the query founds any corresponding data
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error while validating: "+e);
            return false;
        }
		
}

}