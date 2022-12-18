package org.loginform.filters;

import org.loginform.Constants;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginPresenceFilter", urlPatterns = "/login/*")
public class LoginPresenceFilter implements Filter {
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;
    String login = req.getParameter("login");
    String password = req.getParameter("password");
    if (login == null || login.trim().isEmpty()) {
      req.setAttribute(Constants.LOGIN_PAGE_MESSAGE_ATTR, "Error: login must be not empty!");
      req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    if (password == null || password.trim().isEmpty()) {
      req.setAttribute(Constants.LOGIN_PAGE_MESSAGE_ATTR, "Error: password must be not empty!");
      req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    filterChain.doFilter(req, resp);
  }
}
