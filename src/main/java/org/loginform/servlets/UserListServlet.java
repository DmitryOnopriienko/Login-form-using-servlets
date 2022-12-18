package org.loginform.servlets;

import org.loginform.Constants;
import org.loginform.usersdata.User;
import org.loginform.usersdata.UserAccounts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserListServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    List<User> userList = UserAccounts.users.values()
            .stream()
            .toList();
    req.setAttribute(Constants.USER_LIST_ATTR, userList);
    req.getRequestDispatcher("users.jsp").forward(req, resp);
  }
}
