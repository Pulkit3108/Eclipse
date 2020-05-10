package com.PM;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void showLoginForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
  res.setContentType("text/html");
  PrintWriter out = res.getWriter();
  out.println("<html>");
  out.println("<head>");
  out.println("<title>Login</title>");
  out.println("</head>");
  out.println("<body>");
  out.println("<br>Please enter username and password");
  out.println("<form method=post>");
  out.println("<br>Username: <input type=text name=username>");
  out.println("<br>Password: <input type=text name=password>");
  out.println("<br><input type=submit>");
  out.println("</form>");
  out.println("</body>");
  out.println("</html>");
 }
 
 public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
  showLoginForm(req, res);
 }
 
 public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
  String username = req.getParameter("username");
  String password = req.getParameter("password");
  if (username.isEmpty() || password.isEmpty()) {
   showLoginForm(req, res);
  } else {
   RequestDispatcher rd = req.getRequestDispatcher("/WelcomeServlet");
   req.setAttribute("username", username);
   rd.forward(req, res);
  }
  
 }
}