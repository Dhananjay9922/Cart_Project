package shop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ServletContext context = null;
    
    public Controller(){
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String str = request.getParameter("forward");
		if(str != null) {
			if(str.equals("Login")) {
				RequestDispatcher rd = this.context.getRequestDispatcher("/Login");
				rd.forward(request, response);
			}else if(str.equals("Books")) {
				RequestDispatcher rd = this.context.getRequestDispatcher("/Books");
				rd.forward(request, response);
			}
			else if(str.equals("Cart")) {
				RequestDispatcher rd = this.context.getRequestDispatcher("/Cart");
				rd.forward(request, response);
			}
//			else if(str.equals("Subject")) {
//				response.sendRedirect("subject.html");
//			}
			else if(str.equals("Subject")) {
				RequestDispatcher rd = this.context.getRequestDispatcher("/Subject");
				rd.forward(request, response);
			}
			else if(str.equals("Cart")) {
				RequestDispatcher rd = this.context.getRequestDispatcher("/Cart");
				rd.forward(request, response);
			}else if(str.equals("CustInfo.html")) {
				response.sendRedirect("CustInfo.html");
			}else if(str.equals("Purchase1")) {
				RequestDispatcher rd = this.context.getRequestDispatcher("/Purchase1");
				rd.forward(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
