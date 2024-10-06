package shop;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		ArrayList<String> al1 = new ArrayList<>();

		out.println("<html><body bgcolor='pink'>");
		out.println("<h1>Book Selected:: <span><a href=\"Login.html\" class=\"logout\">Logout</a></span></h1><br><br>");
		out.println("<form action='Controller?forward=CustInfo.html' method='post'>");

		al1 = (ArrayList<String>) session.getAttribute("Cart");
		if (al1 != null) {
		    for (String ss : al1) {
		        out.println(ss + "<br>");
		    }
		} else {
		    out.println("No book selected");
		}

		out.println("<br><br><br><a href='Subject'>Cancel</a>");
		out.println("<br>");
		out.println("<input type='submit' value='Confirm'>");
		out.println("</form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
