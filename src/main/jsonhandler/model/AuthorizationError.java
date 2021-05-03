package main.jsonhandler.model;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorizationError {
        private String error;
        private String error_description;

    public AuthorizationError() {
    }

    public void isAllInitialized() {
        assertNotNull(error);
        assertNotNull(error_description);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }
}
