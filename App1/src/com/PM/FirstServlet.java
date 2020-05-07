package com.PM;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("hello");
		String uname = request.getParameter("name");
		String pass = request.getParameter("pass");
		if(uname.equalsIgnoreCase("Hunter") && pass.equals("8520")) {
			out.println("Welcome admin");
		}
		else {
			out.println("You are not admin");
		}
	}

}
