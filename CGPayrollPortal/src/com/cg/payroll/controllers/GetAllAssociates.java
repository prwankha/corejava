package com.cg.payroll.controllers;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

@WebServlet("/GetAllAssociates")
public class GetAllAssociates extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PayrollServices services = new PayrollServicesImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Associate> associates = services.getAllAssociateDetails();

		RequestDispatcher dispatcher = request.getRequestDispatcher("GetAllAssociatePage.jsp");
		request.setAttribute("associates", associates);
		dispatcher.forward(request, response);
	}
}