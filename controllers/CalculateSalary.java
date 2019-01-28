package com.cg.payroll.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

@WebServlet("/CalculateSalary")
public class CalculateSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public PayrollServices services=new PayrollServicesImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int associateId=Integer.parseInt(request.getParameter("associateId"));
		
		Salary salary=null;
		try {
			services.calculateNetSalary(associateId);
			salary = services.getAssociateDetails(associateId).getSalary();
		} catch (AssociateDetailsNotFoundException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("SalaryCalculatedPage.jsp");
		request.setAttribute("salary", salary);
		dispatcher.forward(request, response);
	}
}