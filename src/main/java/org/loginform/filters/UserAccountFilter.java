package org.loginform.filters;

import org.loginform.usersdata.UserAccounts;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "userAccountFilter", urlPatterns = "/login/*")
public class UserAccountFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;
    String login = req.getParameter("login");
    String password = req.getParameter("password");
    if (!UserAccounts.users.containsKey(login)) {
      req.setAttribute("message", "Error: there is no user with this login!");
      req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    if (!UserAccounts.users.get(login).getPassword().equals(password)) {
      req.setAttribute("message", "Error: Wrong password!");
      req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    filterChain.doFilter(req, resp);
  }
}
