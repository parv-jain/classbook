package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Send
 */
@WebServlet("/Send")
public class Send extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Send() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{
				String url="jdbc:mysql://localhost:3306/classbook";
				PrintWriter pw=response.getWriter();
				String message = request.getParameter("message");
				String user = request.getParameter("user");
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,"root","parv1608");	
				PreparedStatement pstmt=con.prepareStatement("insert into chat(user,message) values(?,?)");
				int id=0;
				pstmt.setString(1,user);
				pstmt.setString(2,message);
				pstmt.executeUpdate();
				response.sendRedirect("Main.jsp");
				}
				catch(Exception e){
					e.printStackTrace();
				}
	}

}
