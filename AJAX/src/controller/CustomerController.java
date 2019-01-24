package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import vo.CustomerVo;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
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

		String no = request.getParameter("name");
//		System.out.println(no);

		if (no != null) {

			CustomerVo customerVo = new CustomerVo();
			customerVo.setCustomerName(no);
			CustomerDao customerDao = new CustomerDao();
			List<CustomerVo> dataList = customerDao.getData(customerVo);

			/*
			 * String data="<table border=2 align=center>"; for(CustomerVo customerVo2 :
			 * dataList) { data+="<tr>"; data+="<td>"+customerVo2.getCustomerId()+"</td>";
			 * data+="<td>"+customerVo2.getCustomerName()+"</td>"; data+="<td>" +
			 * customerVo2.getCustomerNumber() + "</td>"; data+="</tr>"; } data+="</table>";
			 */

			String data = "<select name=custNo id=custNo onchange=loadFinal()><option>Select</option>";
			int c = dataList.size();
			int val = 0;
			for (CustomerVo customerVo2 : dataList) {
				if (c == 1) {
					data = "<table align=center border=1>";
					data += "<tr>";
					data += "<td>" + customerVo2.getCustomerId() + "</td>";
					data += "<td>" + customerVo2.getCustomerName() + "</td>";
					data += "<td>" + customerVo2.getCustomerNumber() + "</td>";
					data += "</tr></table>";
				} else {
					val++;
					data += "<option value=" + customerVo2.getCustomerNumber() + ">" + customerVo2.getCustomerNumber()
							+ "</option>";
					if (c == val) {
						data += "</select>";
					}
				}
			}

			response.getWriter().println(data);
		}else {
			long number=Long.parseLong(request.getParameter("num"));
			
			CustomerVo customerVo=new CustomerVo();
			customerVo.setCustomerNumber(number);
			
			CustomerDao customerDao=new CustomerDao();
			List<CustomerVo> dataList=customerDao.getCustomerData(customerVo);
			
			String data="<table align=center border=1>";
			
			for(CustomerVo customerVo2: dataList) {
				System.out.println(customerVo2.getCustomerNumber());
				data+="<tr>";
				data+="<td>" + customerVo2.getCustomerId() + "</td>";
				data+="<td>" + customerVo2.getCustomerName() + "</td>";
				data+="<td>" + customerVo2.getCustomerNumber() + "</td>";
				data+="</tr></table>";
			}
			System.out.println(data);
			response.getWriter().println(data);
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
