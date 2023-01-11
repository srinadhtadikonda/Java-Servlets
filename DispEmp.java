
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class DispEmp extends HttpServlet{

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   Statement stmt=null;
   Connection conn=null;
     response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      
     out.println("<html>");
  out.println("<head><title>demo</title></head>");
out.println("<body>");
      try {
           Class.forName("org.gjt.mm.mysql.Driver");
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demobase","root","brilliant");
           stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT eno,ename,esal,egrade from myemp");
out.println("<center>");
out.println("<table border=2>");
out.println("<tr>");
out.println("<td>ENO</td>");
out.println("<td>ENAME</td>");
out.println("<td>ESAL</td>");
out.println("<td>EGRADE</td>");
           while(rs.next())
           {
       
            int teno  = rs.getInt("eno");
            String tename = rs.getString("ename");
            int tesal = rs.getInt("esal");
           String tegrade=rs.getString("egrade");
          
            out.println("<tr><td> "+ teno + "</td>");
            out.println("<td>" + tename + "</td>");
            out.println("<td> " + tesal + "</td>");
            out.println("<td> " + tegrade + "</td>");
         }
out.println("</table></center>");
         out.println("</body></html>");
         rs.close();
         stmt.close();
         conn.close();
      } catch(Exception ex)
{
out.println(ex);
}

}
}