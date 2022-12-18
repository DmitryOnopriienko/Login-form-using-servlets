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

@WebFilter(filterName = "authorizedUserFilter",
        urlPatterns = {"/logout/*", "/users", "/menu.jsp"})
public class AuthorizedUserFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;

    if (req.getSession().getAttribute(Constants.IS_LOGGED_IN_SESSION_ATTR).equals(false)) {
      req.setAttribute(Constants.LOGIN_PAGE_MESSAGE_ATTR,
              "You are not logged in! Please log in to continue");
      req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }
}
