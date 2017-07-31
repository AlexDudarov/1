package gmail.alexdudarkov.sportshop.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import gmail.alexdudarkov.sportshop.model.LoginDTO;

import gmail.alexdudarkov.sportshop.service.ServiceException;
import gmail.alexdudarkov.sportshop.service.UserServiceImpl;
import gmail.alexdudarkov.sportshop.service.model.UserDTO;
import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(LoginServlet.class);

    private final UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO loginObject = (UserDTO) req.getSession().getAttribute("user");
        if (loginObject == null) {
            req.getSession().setAttribute("user", UserDTO.newBuilder().build());
        }
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        logger.info("login request submitted");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login == "" || password == "") {
            req.setAttribute("error", "empty login or password");
            try {
                req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug(login + ":" + password);
            }
            UserDTO user = null;
            try {
                user = userService.get(login, password);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            try {
                if (user != null) {
                    req.getSession().setAttribute("user", user);
                    switch (user.getRole()) {
                        case ADMIN:
                            System.out.println("User is admin. Redirect to /admin/documents");
                            req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
                            break;
                        case USER:
                            System.out.println("Redirect to /user/documents");
                            req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown role");
                    }
                } else {
                    System.out.println("Credentials is not valid");
                    req.getSession().setAttribute("loginObject", new LoginDTO(login, password));
                    req.getSession().setAttribute("error", "Credentials is not valid");
                    resp.sendRedirect(req.getContextPath() + "/login");
                }
            } catch (IOException e) {
                System.out.println("ExceptionServlet during request");
                throw new IllegalStateException("Unknown error");
            }
        }
    }
}
