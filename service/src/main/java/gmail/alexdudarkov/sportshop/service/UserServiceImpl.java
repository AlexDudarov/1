package gmail.alexdudarkov.sportshop.service;

import gmail.alexdudarkov.sportshop.dao.UserDao;
import gmail.alexdudarkov.sportshop.dao.UserDaoImpl;
import gmail.alexdudarkov.sportshop.model.User;
import gmail.alexdudarkov.sportshop.model.UserInformation;
import gmail.alexdudarkov.sportshop.service.model.UserDTO;

import java.io.Serializable;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance = null;
    private static UserDaoImpl userDao=new UserDaoImpl();

    private UserServiceImpl() {
        // Exists only to default instantiation.
    }

    public static synchronized UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }
    @Override
    public UserDTO get(String login, String password) throws ServiceException {
        userDao.openCurrentSessionWithTransaction();
        User u=new User();
        u.setLogin(login);
        List<User> user=null;
            user = userDao.findAllByExample(u);
            userDao.closeCurrentSessionWithTransaction();

        if (!user.isEmpty() && user.get(0).getPassword().equals(password)) {
            UserDTO.Builder builder= UserDTO.newBuilder();
            builder.login(user.get(0).getLogin()).password(user.get(0).getPassword()).role(user.get(0).getRole());
            builder.build();
            return builder.build();
        } else {
            return null;
        }


    }

    @Override
    public UserDTO findById(Serializable id) throws ServiceException {

        userDao.openCurrentSessionWithTransaction();
        User user = userDao.findById(id);
        userDao.closeCurrentSessionWithTransaction();
        UserDTO userDto = new UserDTO(user);
        return userDto;
    }
    public Long save(UserDTO userDto){
        userDao.openCurrentSessionWithTransaction();
        Long id=(Long)userDao.save(convertDtoIntoDao(userDto));
        userDao.closeCurrentSessionWithTransaction();
        return id;
    }
    private User convertDtoIntoDao(UserDTO userDto){
        User user=new User();
        UserInformation userInformation=new UserInformation();
        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setRole(userDto.getRole());
        user.setPassword(userDto.getPassword());
        userInformation.setGender(userDto.getGender());
        userInformation.setName(userDto.getName());
        userInformation.setSurname(userDto.getSurname());
        user.setUserInformation(userInformation);
        userInformation.setUser(user);
        return user;
    }
}
