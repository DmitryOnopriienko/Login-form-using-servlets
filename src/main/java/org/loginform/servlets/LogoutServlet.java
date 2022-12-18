package org.loginform.servlets;

import org.loginform.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    req.getSession().setAttribute(Constants.IS_LOGGED_IN_SESSION_ATTR, false);
    resp.sendRedirect("index.jsp");
  }
}
