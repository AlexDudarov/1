package gmail.alexdudarkov.sportshop.servlet.administration;

import gmail.alexdudarkov.sportshop.service.BrandGoodServiceImpl;
import gmail.alexdudarkov.sportshop.service.GoodServiceImpl;
import gmail.alexdudarkov.sportshop.service.TypeGoodServiceImpl;
import gmail.alexdudarkov.sportshop.service.model.BrandGoodDTO;
import gmail.alexdudarkov.sportshop.service.model.GoodDTO;
import gmail.alexdudarkov.sportshop.service.model.TypeGoodDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;


public class AdminAddGoodServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setAttribute("brands",BrandGoodServiceImpl.getInstance().findAll());
       req.setAttribute("types", TypeGoodServiceImpl.getInstance().findAll());
        req.getRequestDispatcher("/WEB-INF/pages/administration/adminGoodsAdd.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long brandId = (Long)req.getAttribute("brand_id");
        Long typeId =(Long)req.getAttribute("type_id");
        Boolean availability =(Boolean)req.getAttribute("availability");
        String model = (String)req.getAttribute("model");
        BigDecimal price = (BigDecimal)req.getAttribute("price");
        String iconPath = (String)req.getAttribute("icon_path");
       // String
       // System.out.println(brandName);

        BrandGoodDTO brandGoodDto=BrandGoodDTO.newBuilder().id(brandId).build();
        TypeGoodDTO typeGoodDto = TypeGoodDTO.newBuilder().id(typeId).build();
        GoodDTO goodDto=GoodDTO.newBuilder()
                .brandGoodDto(brandGoodDto)
                .typeGoodDto(typeGoodDto)
                .availability(availability)
                .iconPath(iconPath)
                .model(model)
                .price(price).build();
        System.out.println(brandGoodDto);
        GoodServiceImpl.getInstance().save(goodDto);
        req.getRequestDispatcher("/WEB-INF/pages/administration/adminGoods.jsp").forward(req, resp);
    }
}
