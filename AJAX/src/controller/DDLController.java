package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import vo.CustomerVo;

/**
 * Servlet implementation class DDLController
 */
@WebServlet("/DDLController")
public class DDLController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DDLController() {
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

		PrintWriter out = response.getWriter();
		String flag = request.getParameter("flag");

		if (flag!=null) {
			String data=request.getParameter("data");
			out.println(data);
		} else {

			CustomerDao customerDao = new CustomerDao();
			List<CustomerVo> list = customerDao.getAllCustomers();

			out.println("<customer>");
			for (CustomerVo customerVo : list) {
				System.out.println(customerVo.getCustomerName() + " " + customerVo.getCustomerId());
				out.println("<customerid>" + customerVo.getCustomerId() + "</customerid>");
				out.println("<customername>" + customerVo.getCustomerName() + "</customername>");
			}
			out.println("</customer>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
