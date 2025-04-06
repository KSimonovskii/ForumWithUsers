package telran.java57.forum.accounting.dao.exceptions;

public class UserExistsException extends RuntimeException {
  public UserExistsException(String message) {
    super(message);
  }
}
