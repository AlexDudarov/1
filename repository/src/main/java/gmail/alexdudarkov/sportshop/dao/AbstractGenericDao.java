package gmail.alexdudarkov.sportshop.dao;


import gmail.alexdudarkov.sportshop.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by User-PC on 20.07.2017.
 */
public abstract class AbstractGenericDao<E> implements GenericDao<E> {

    private Session currentSession;

    private Transaction currentTransaction;

    private final Class<E> entityClass;

    public AbstractGenericDao() {
        this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    public Session openCurrentSession() {
        if (currentSession == null) {
            currentSession = sessionFactory.openSession();
        }
        return currentSession;
    }

    public void closeCurrentSession() {
        if (currentSession != null) {
            currentSession.close();
        }
    }

    public Session openCurrentSessionWithTransaction() {

        currentSession = sessionFactory.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }


    public Session getCurrentSession() {
        return currentSession;
    }


    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }


    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }


    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    @Override
    public Serializable save(E entity) {
        return getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(E entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(E entity) {
        getCurrentSession().delete(entity);
    }



    @Override
    public List<E> findAll() {
        return getCurrentSession().createCriteria(this.entityClass).list();
    }

    @Override
    public List<E> findAllByExample(E entity) {
        Example example = Example.create(entity).ignoreCase().enableLike().excludeZeroes();
        return getCurrentSession().createCriteria(this.entityClass).add(example).list();
    }

    @Override
    public E findById(Serializable id) {
        return (E) getCurrentSession().get(this.entityClass, id);
    }


}
