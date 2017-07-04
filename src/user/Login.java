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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter pw=response.getWriter();
			String username=request.getParameter("username");
			String pass=request.getParameter("pass");
			String url="jdbc:mysql://localhost:3306/classbook";
			int flag=1;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","parv1608");
			PreparedStatement pstmt1=con.prepareStatement("select * from users");
			ResultSet rs=pstmt1.executeQuery();
			while(rs.next()){
				if(username.equals(rs.getString("Username")) && pass.equals(rs.getString("Userpassword"))){
					flag=0;
					break;
				}
			}
			if(flag==0){
				HttpSession hs;
				hs=request.getSession();
				hs.setAttribute("user",username);
				response.sendRedirect("Main.jsp");
			}
			else{
				response.setContentType("text/html");
				//request.getRequestDispatcher("index.html").include(request,response);
				pw.println("No username, password match found");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
