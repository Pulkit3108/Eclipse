package com.PM;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PM.LoginDB;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("name");
		String pass = request.getParameter("pass");

		LoginDB db = new LoginDB();
		try {
			if (db.check(uname, pass)) {
				out.print("login successful");
			} else {
				out.print("login failed");
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}
}
