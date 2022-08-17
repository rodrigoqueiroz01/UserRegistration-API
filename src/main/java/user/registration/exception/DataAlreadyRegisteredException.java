package user.registration.exception;

public class DataAlreadyRegisteredException extends RuntimeException {

    public DataAlreadyRegisteredException(String message) {
        super(message);
    }

}
