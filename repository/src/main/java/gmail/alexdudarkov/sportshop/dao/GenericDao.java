package gmail.alexdudarkov.sportshop.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by User-PC on 20.07.2017.
 */
public interface GenericDao<E> {

    Serializable save(E entity) throws DaoException;


    public void saveOrUpdate(E entity) throws DaoException;


   public void delete(E entity) throws DaoException;





   public List<E> findAll() throws DaoException;


    public List<E> findAllByExample(E entity) throws DaoException;


    public E findById(Serializable id) throws DaoException;

}
