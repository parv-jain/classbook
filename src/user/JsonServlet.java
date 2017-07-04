package user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String semName = request.getParameter("semName");
        String branchName = request.getParameter("branchName");
        List<String> list = new ArrayList<String>();
        String json = null;

        if (semName.equals("1") && branchName.equals("civil")) {
            list.add("Applied Mathematics 1");
            list.add("Applied Physics 1");
            list.add("Applied Chemistry");
            list.add("Electrical Technology");
            list.add("Fundamentals of Computing");
            list.add("Manufacturing Practices");
        } else if (semName.equals("1") && branchName.equals("cse")) {
        	list.add("Applied Mathematics 1");
            list.add("Applied Physics 1");
            list.add("Applied Chemistry");
            list.add("Electrical Technology");
            list.add("Fundamentals of Computing");
            list.add("Manufacturing Practices");    
        } else if (semName.equals("1") && branchName.equals("it")) {
        	list.add("Applied Mathematics 1");
            list.add("Applied Physics 1");
            list.add("Applied Chemistry");
            list.add("Electrical Technology");
            list.add("Fundamentals of Computing");
            list.add("Manufacturing Practices");
        } else if (semName.equals("1") && branchName.equals("ece")) {
        	list.add("Applied Mathematics 1");
            list.add("Applied Physics 1");
            list.add("Applied Chemistry");
            list.add("Electrical Technology");
            list.add("Fundamentals of Computing");
            list.add("Manufacturing Practices");
		} else if (semName.equals("1") && branchName.equals("eee")) {
			list.add("Applied Mathematics 1");
            list.add("Applied Physics 1");
            list.add("Applied Chemistry");
            list.add("Electrical Technology");
            list.add("Fundamentals of Computing");
            list.add("Manufacturing Practices");
		} else if (semName.equals("1") && branchName.equals("mechanical")) {
			list.add("Applied Mathematics 1");
            list.add("Applied Physics 1");
            list.add("Applied Chemistry");
            list.add("Electrical Technology");
            list.add("Fundamentals of Computing");
            list.add("Manufacturing Practices");
		} else{
			list.add("No Subject Found");
		}
        

        json = new Gson().toJson(list);
        response.setContentType("application/json");
        response.getWriter().write(json);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
