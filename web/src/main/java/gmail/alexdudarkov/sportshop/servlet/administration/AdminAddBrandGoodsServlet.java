package gmail.alexdudarkov.sportshop.servlet.administration;

import gmail.alexdudarkov.sportshop.service.BrandGoodServiceImpl;
import gmail.alexdudarkov.sportshop.service.model.BrandGoodDTO;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminAddBrandGoodsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/administration/adminGoodsBrandAdd.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brandName=  (String)req.getParameter("brand_name");
        System.out.println(brandName);
        BrandGoodDTO brandGoodDto=BrandGoodDTO.newBuilder().name(brandName).build();
        System.out.println(brandGoodDto);
        BrandGoodServiceImpl.getInstance().save(brandGoodDto);
        req.getRequestDispatcher("/WEB-INF/pages/administration/adminGoods.jsp").forward(req, resp);
    }

}

