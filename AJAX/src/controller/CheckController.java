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
 * Servlet implementation class CheckController
 */
@WebServlet("/CheckController")
public class CheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		CustomerDao customerDao=new CustomerDao();
		
		PrintWriter out=response.getWriter();
		out.println("<customer>");
		
		if(name!=null) {
			String data="<name></name>";
			CustomerVo customerVo=new CustomerVo();
			customerVo.setCustomerName(name);
			List<CustomerVo> list=customerDao.getData(customerVo);
			if(list.isEmpty()) {
				data="<name>Name Available</name>";
				out.println(data);
			}else {
				data="<name>Name not available</name>";
				out.println(data);
			}
		}else {
			String data="<name></name>";
			out.println(data);
		}
		if(email.equals("")) {
			String data="<email></email>";
			CustomerVo customerVo=new CustomerVo();
			customerVo.setCustomerEmail(email);
			List<CustomerVo> list=customerDao.getEmail(customerVo);
			if(list.isEmpty()) {
				data="<email>Email Available</email>";
				out.println(data);
			}else {
				data="<email>Email Not Available</email>";
				out.println(data);
			}
		}else {
			String data="<email></email>";
			out.print(data);
		}
		
		out.println("</customer>");
	}

}
