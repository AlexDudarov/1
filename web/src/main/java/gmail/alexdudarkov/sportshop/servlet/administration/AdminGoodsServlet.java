package gmail.alexdudarkov.sportshop.servlet.administration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminGoodsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("Logout");
        //req.getSession().setAttribute("user", null);
        req.getRequestDispatcher("/WEB-INF/pages/administration/adminGoods.jsp").forward(req, resp);
    }
}
