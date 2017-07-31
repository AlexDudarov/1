package gmail.alexdudarkov.sportshop.service;


public class ServiceException extends Exception {


    private static final long serialVersionUID = -743460649518041306L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException(String message, Exception e) {
        super(message, e);
    }
}
