package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Subject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Subject() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		ArrayList<String> al = new ArrayList<>();
		ArrayList<String> al1 = (ArrayList<String>) session.getAttribute("Cart");

		if (al1 != null) {
		    al.addAll(al1);
		}

		String books[] = request.getParameterValues("book");
		if (books != null) {
		    for (String bookName : books) {
		        al.add(bookName);
		        // Insert each book into the database
		        try {
		            Connection connection = new ConnectionServlet().con;

		            String str = "insert into bookcart(BookName) values(?);";
		            
		            PreparedStatement pstmt = connection.prepareStatement(str);

		            pstmt.setString(1, bookName);
		            pstmt.executeUpdate();  // Use executeUpdate for insert operations

		        } catch (ClassNotFoundException | SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    session.setAttribute("Cart", al);
		}

		out.println("<html><body bgcolor='pink'>");
		out.println("<form action='Controller?forward=Books' method='post'>");
		out.println("<h1>Select Subject:: <span><a href=\"Login.html\" class=\"logout\">Logout</a></span></h1><br><br>");
		out.println("<br><br><input type=\"radio\" name=\"subject\" value=\"java\">Java");
		out.println("<br><br><input type=\"radio\" name=\"subject\" value=\"python\">Python");
		out.println("<br><br><input type=\"radio\" name=\"subject\" value=\"c++\">C++");
		out.println("<br><br><input type=\"radio\" name=\"subject\" value=\"javascript\">JavaScript");
		out.println("<br><br><input type=\"radio\" name=\"subject\" value=\"frontend\">Front-End");
		out.println("<br><br><br><a href='Controller?forward=Cart'>Cart</a>");
		out.println("<br>");
		out.println("<input type='submit' value='Show Books'>");
		out.println("</form></body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
