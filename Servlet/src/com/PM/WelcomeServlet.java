package com.PM;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class WelcomeServlet extends HttpServlet{
 
 public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {  String username = (String) req.getAttribute("username");
  
  PrintWriter out = res.getWriter();
  out.println("Hello: " + username);
 }
}
