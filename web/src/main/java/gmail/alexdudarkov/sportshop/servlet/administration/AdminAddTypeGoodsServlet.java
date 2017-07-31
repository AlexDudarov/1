package gmail.alexdudarkov.sportshop.servlet.administration;

import gmail.alexdudarkov.sportshop.service.TypeGoodServiceImpl;
import gmail.alexdudarkov.sportshop.service.model.TypeGoodDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminAddTypeGoodsServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/administration/adminGoodsTypeAdd.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeName=  (String)req.getParameter("type_name");
        System.out.println(typeName);
        TypeGoodDTO typeGoodDto=TypeGoodDTO.newBuilder().name(typeName).build();
        System.out.println(typeGoodDto);
        TypeGoodServiceImpl.getInstance().save(typeGoodDto);
        req.getRequestDispatcher("/WEB-INF/pages/administration/adminGoods.jsp").forward(req, resp);
    }

}
