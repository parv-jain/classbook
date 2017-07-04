package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String dbURL = "jdbc:mysql://localhost:3306/classbook";
	private String dbUser = "root";
	private String dbPass = "parv1608";
	 
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String sem= request.getParameter("sem");
		String branch=request.getParameter("branch");
		String subject=request.getParameter("subject");
		PrintWriter pw=response.getWriter();
		pw.println("\nShowing results for subject "+ subject+" branch "+branch+" semester "+sem+"\n");
		try {
            // connects to the database
        	Class.forName("com.mysql.jdbc.Driver");
			
        	Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        	
        	 String sql = "SELECT * FROM uploads";
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs=statement.executeQuery();
 			 while(rs.next()){
 				 pw.println("\nSemester: "+rs.getString("Sem")+"\nBranch: "+rs.getString("branch")+"\nSubject: "+rs.getString("subject")+"\nFile: ");
 				 pw.println(rs.getBlob("file"));
 			 }
		}catch(Exception e){
			System.out.println(e);
		}
 
	}
}
