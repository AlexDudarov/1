package gmail.alexdudarkov.sportshop.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User-PC on 26.07.2017.
 */
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Logout");
        req.getSession().setAttribute("user", null);
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
