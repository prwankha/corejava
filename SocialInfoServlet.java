package com.cg.project.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.project.bean.UserBean;

@WebServlet("/SocialInfoServlet")
public class SocialInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String movieName=request.getParameter("movieName");
		String fruitName=request.getParameter("fruitName");
		String bookName=request.getParameter("bookName");
		UserBean bean = new UserBean(firstName, lastName, fruitName, movieName, bookName);
		RequestDispatcher dispatcher=request.getRequestDispatcher("displayPage.jsp");
		request.setAttribute("bean", bean);
		dispatcher.forward(request, response);
	}

}
