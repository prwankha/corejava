package com.cg.payroll.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

@WebServlet("/accept")
public class AcceptAssociate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PayrollServices Services=new PayrollServicesImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailId = request.getParameter("emailId");
		String department = request.getParameter("department");
		String designation = request.getParameter("designation");
		String pancard = request.getParameter("pancard");
		String bankName = request.getParameter("bankName");
		int yearlyInvestmentUnder80C = Integer.parseInt(request.getParameter("yearlyInvestmentUnder80C"));
		int basicSalary = Integer.parseInt(request.getParameter("basicSalary"));
		int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
		String ifscCode = request.getParameter("ifscCode");
		int epf = Integer.parseInt(request.getParameter("epf"));
		int companyPf = Integer.parseInt(request.getParameter("companyPf"));

		Associate associate=new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, 
				new Salary(basicSalary, epf, companyPf), new BankDetails(accountNumber, bankName, ifscCode));
		
		Services.acceptAssociate(associate);
		request.setAttribute("associate", associate);
		RequestDispatcher dispatcher=request.getRequestDispatcher("AssociateAcceptedPage.jsp");
		dispatcher.forward(request, response);
	}
}