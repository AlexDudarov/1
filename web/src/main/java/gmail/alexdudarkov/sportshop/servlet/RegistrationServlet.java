package gmail.alexdudarkov.sportshop.servlet;

import gmail.alexdudarkov.sportshop.model.Role;
import gmail.alexdudarkov.sportshop.service.ServiceException;
import gmail.alexdudarkov.sportshop.service.UserServiceImpl;
import gmail.alexdudarkov.sportshop.service.model.UserDTO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(IndexServlet.class);

    private final UserServiceImpl userService = UserServiceImpl.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/reg.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserDTO user = null;
        if (login != "" && password != "") {
            try {
                user = userService.get(login, password);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            if (user != null) {
                req.setAttribute("error", "Credentials is not valid");
                resp.sendRedirect(req.getContextPath() + "/registration");
            } else {
                UserDTO userDto = UserDTO.newBuilder().login(login).password(password).role(Role.USER).build();
                userService.save(userDto);
            }
        } else {
            req.setAttribute("error", "Credentials is not valid");
            resp.sendRedirect(req.getContextPath() + "/registration");
        }


    }
}
