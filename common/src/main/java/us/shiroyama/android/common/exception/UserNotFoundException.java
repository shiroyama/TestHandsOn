package us.shiroyama.android.common.exception;

/**
 * {@link us.shiroyama.android.common.entity.User}が見つからなかったときに投げられる例外
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
