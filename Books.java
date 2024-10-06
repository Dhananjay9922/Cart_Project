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

public class Books extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Books() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession  session = request.getSession(false);
		
		String subname = request.getParameter("subject");
		out.println("<html><body>");
		out.println("<form action='Controller?forward=Subject' method='post'>");
		out.println("<h1>Books </h1>");

		try {
			Connection connection = new ConnectionServlet().con;
			
			String str = "select bookname from book where sid=(select sid from subject where subname=?);";
			PreparedStatement pstmt = connection.prepareStatement(str);
			
			pstmt.setString(1, subname);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				out.println(rs.getString("bookname")+"<br>");
				out.println("<input type='checkbox' name='book' value='" + rs.getString("bookname") + "'>" + rs.getString("bookname") + "<br>");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		out.println("<input type='submit' value='Add Books'>");
		out.println("</form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
