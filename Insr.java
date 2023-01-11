import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Insr extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
	
        int teno = Integer.parseInt(request.getParameter("eno"));
        String tename = request.getParameter("ename");
        int tesal = Integer.parseInt(request.getParameter("esal"));
       String tegrade = request.getParameter("egrade");

        
        try {
        
            // loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");
            
            //creating connection with the database 
            Connection con = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/demobase","root","brilliant");
             out.print("Connection Ok");

            PreparedStatement ps = con.prepareStatement("insert into myemp values(?,?,?,?)");

            ps.setInt(1, teno);
            ps.setString(2, tename);
            ps.setInt(3, tesal);
            ps.setString(4,tegrade);
            int i = ps.executeUpdate();
            
            if(i > 0) {
                out.println("You are sucessfully registered");
            }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
	
    }
}

