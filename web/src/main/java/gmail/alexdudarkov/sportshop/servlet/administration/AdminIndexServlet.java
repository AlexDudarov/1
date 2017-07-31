package gmail.alexdudarkov.sportshop.servlet.administration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User-PC on 26.07.2017.
 */
public class AdminIndexServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // System.out.println("Logout");
        //req.getSession().setAttribute("user", null);
        req.getRequestDispatcher("/WEB-INF/pages/administration/adminMenu.jsp").forward(req, resp);
    }
}
