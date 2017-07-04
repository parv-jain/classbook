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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Register() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String url="jdbc:mysql://localhost:3306/classbook";
			PrintWriter pw=response.getWriter();
			int flag=1;
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			String pass=request.getParameter("pass");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","parv1608");
			PreparedStatement pstmt1=con.prepareStatement("select * from users");
			ResultSet rs=pstmt1.executeQuery();
			response.setContentType("text/html");
			while(rs.next()){
				if(email.equals(rs.getString("Useremail")) || username.equals(rs.getString("Username"))){
					pw.println("<h3><font color=red>error user already registered, please choose unique username and email</font></h3>");
					RequestDispatcher rd=request.getRequestDispatcher("register.html");
					rd.include(request,response);
					flag=0;
				}
			}
			if(flag == 1){
				PreparedStatement pstmt=con.prepareStatement("insert into users values(?,?,?,?)");
				int id=0;
				pstmt.setInt(1,id);
				pstmt.setString(2,username);
				pstmt.setString(3,email);
				pstmt.setString(4,pass);
				pstmt.executeUpdate();
				pw.println("<h3><font color=green>Registration Successfull</font><h3>");
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
}
