package gmail.alexdudarkov.sportshop.dao;


public class DaoException extends Exception {
    private static final long serialVersionUID = -5087489878610306740L;

    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Exception e) {
        super(e);
    }

    public DaoException(String message, Exception e) {
        super(message, e);
    }
}
