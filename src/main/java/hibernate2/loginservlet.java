package hibernate2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate2.login;
import hibernate2.logincontroller;
@WebServlet("/login")
public class loginservlet extends HttpServlet{

	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		
		String email = req.getParameter("email");
		
		String password = req.getParameter("password");
		
		login d = new login(0, name,email,password);
		
		logincontroller dc = new logincontroller();
		
		dc.insertion(name,email,password);
		
		resp.sendRedirect("getall.jsp");
	}

}
