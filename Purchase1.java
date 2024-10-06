package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Purchase1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Purchase1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String cname = request.getParameter("cname");
		String addr = request.getParameter("addr");
		ArrayList<String> al1 = new ArrayList<String>();
		HttpSession session = request.getSession(false);
		out.println("<html><body bgcolor='pink'>");
		out.println("<h1><span><a href=\"Login.html\" class=\"logout\">Logout</a></span></h1><br><br>");
		out.println("<h2>Thank you, <h4>" +cname+ "</h4></h2><br><br>");
		out.println("Purchase Books<br>");
		al1 = (ArrayList<String>)session.getAttribute("Cart");
		if(al1 != null) {
			for(String ss: al1) {
				out.println(ss + "<br>");
			}
		}
		out.println("</body></html>");
	}

	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
