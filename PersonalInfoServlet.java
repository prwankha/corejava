package com.cg.project.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.project.bean.UserBean;

@WebServlet("/PersonalInfoServlet")
public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		UserBean bean = new UserBean(firstName, lastName);
		RequestDispatcher dispatcher=request.getRequestDispatcher("socialInfoPage.jsp");
		request.setAttribute("bean", bean);
		dispatcher.forward(request, response);
	}
}

