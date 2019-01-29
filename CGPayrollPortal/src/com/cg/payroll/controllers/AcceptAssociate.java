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

	public PayrollServices Services = new PayrollServicesImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailId = request.getParameter("emailId");
		String department = request.getParameter("department");
		String designation = request.getParameter("designation");
		String pancard = request.getParameter("pancard");
		String bankName = request.getParameter("bankName");
		String ifscCode = request.getParameter("ifscCode");
		int yearlyInvestmentUnder80C = Integer.parseInt(request.getParameter("yearlyInvestmentUnder80C"));
		int basicSalary = Integer.parseInt(request.getParameter("basicSalary"));
		int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
		int epf = Integer.parseInt(request.getParameter("epf"));
		int companyPf = Integer.parseInt(request.getParameter("companyPf"));

		/*if (!firstName.equals("[A-Z][a-z]{1-19}")|| !lastName.equals("[A-Z][a-z]{1-19}") || !emailId.equals("[a-z][.][a-z]@[a-z].com")
				|| !department.equals("[A-Z][a-z]{1-19}") || !designation.equals("[A-Z][a-z]{1-19}") || !pancard.equals("[A-Z][a-z]{1-19}") ||! bankName.equals("[A-Z][a-z]{1-19}")
				||! ifscCode.equals("[A-Z][a-z]{1-19}") || yearlyInvestmentUnder80C <= 0 || basicSalary <= 0 || accountNumber <= 0
				|| epf <= 0 || companyPf <= 0) {
			request.setAttribute("error", "Invalid data entered!!!!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("AcceptAssociatePage.jsp");
			dispatcher.forward(request, response);
		}*/

		Associate associate = new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation,
				pancard, emailId, new Salary(basicSalary, epf, companyPf),
				new BankDetails(accountNumber, bankName, ifscCode));
		Services.acceptAssociate(associate);

		request.setAttribute("success",
				"Associate registered successfully with associate ID " + associate.getAssociateId());
		RequestDispatcher dispatcher = request.getRequestDispatcher("AcceptAssociatePage.jsp");
		dispatcher.forward(request, response);
	}
}