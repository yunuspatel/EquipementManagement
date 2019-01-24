package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AJAXServletController
 */
@WebServlet("/AJAXServletController")
public class AJAXServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AJAXServletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String action = request.getParameter("action");

		if (action.equals("Demo1")) {
			String fullname = request.getParameter("fullname");
			System.out.println(fullname);
			response.setContentType("text/html");
			response.getWriter().println("Hello " + fullname);
		}else {
			int num1=Integer.parseInt(request.getParameter("number1"));
			int num2=Integer.parseInt(request.getParameter("number2"));
			System.out.println(num1+num2);
			String control="<select id=abcd><option value=" + (num1+num2) + ">" + (num1+num2) + "</option>";
			response.getWriter().println(control);
		}
	}

}
