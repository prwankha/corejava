package com.cg.payroll.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

@WebServlet("/GetAssociate")
public class GetAssociate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PayrollServices services = new PayrollServicesImpl();
	Associate associate;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int associateId=Integer.parseInt(request.getParameter("associateId"));
		try {
			associate=services.getAssociateDetails(associateId);
		} catch (AssociateDetailsNotFoundException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("GetAssociatePage.jsp");
		request.setAttribute("associate", associate);
		dispatcher.forward(request, response);
	}
}