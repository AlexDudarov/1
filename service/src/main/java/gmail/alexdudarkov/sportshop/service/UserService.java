package gmail.alexdudarkov.sportshop.service;

import gmail.alexdudarkov.sportshop.service.model.UserDTO;

import java.io.Serializable;


public interface UserService {
    public UserDTO get(String login, String password) throws ServiceException;
    public UserDTO findById(Serializable id) throws ServiceException;

}
