package databasestudy;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletdemo")
public class connectdatabase extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   String Username,Password,ConfirmPassword,FirstName,LastName,PhoneNo,Location,Email;
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		  PrintWriter out=response.getWriter();
		    
		     Username=request.getParameter("username");
		     Password=request.getParameter("password");
		     ConfirmPassword=request.getParameter("ConfirmPassword");
		     
		     FirstName=request.getParameter("FirstName");
		     LastName=request.getParameter("LastName");
		     
		     Email=request.getParameter("Email");
		     PhoneNo=request.getParameter("PhoneNo");
		     
		     Location=request.getParameter("Location");
/*		     
		 //  out.print("hello"+name+"/t"+password);
	   if(name.equals("admin") && password.equals("admin"))
		   {
			  
			  out.println("login successfuly");
		   }
	   else{
		   out.println("incorrect username and password......!");
	   }
	   out.close();
	}
	
	
	
	 public servletdemo() 
	    {
	        super();
	
	    }
*/
		     try{
		         
		         //loading drivers for mysql
		         Class.forName("com.mysql.jdbc.Driver");

		 	//creating connection with the database 
		           Connection  con=DriverManager.getConnection
		                      ("jdbc:mysql:/ /localhost:3306/sonoo","root","root");

		         PreparedStatement ps=con.prepareStatement
		                   ("insert into Student values(?,?,?,?,?,?,?,?)");

		         ps.setString(1, Username);
		         ps.setString(2, Password);
		         ps.setString(3, ConfirmPassword);
		         
		         ps.setString(4, FirstName);
		         ps.setString(5, LastName);
		         ps.setString(6, Email);
		         
		         ps.setString(7, PhoneNo);
		         ps.setString(8, Location);
		         
		         int i=ps.executeUpdate();
		         
		           if(i>0)
		           {
		             out.println("You are sucessfully registered");
		           }
		         
		         }
		         catch(Exception se)
		         {
		             se.printStackTrace();
		         }
		 	
		       }
		   }