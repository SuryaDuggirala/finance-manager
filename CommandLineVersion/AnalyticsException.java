/**
 * An exception thrown when issues are produced while analyzing file input.
 * Created by Surya on 6/1/17.
 */
class AnalyticsException extends Exception {
    AnalyticsException(String message) {
        super(message);
    }

    static AnalyticsException error(String message, Object... args) {
        return new AnalyticsException(String.format(message, args));
    }

}
