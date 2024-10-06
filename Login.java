package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Login() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession  session = request.getSession(true);
		
		String uname = request.getParameter("uname");
		String upass = request.getParameter("pwd");
		
		try {
			Connection connection = new ConnectionServlet().con;
			
			String str = "select * from users where uname=? and upass=?";
			PreparedStatement pstmt = connection.prepareStatement(str);
			
			pstmt.setString(1, uname);
			pstmt.setString(2, upass);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				response.sendRedirect("Subject");
			}else {
				out.println("<h3> Username or Password Incorrect</h3>");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
