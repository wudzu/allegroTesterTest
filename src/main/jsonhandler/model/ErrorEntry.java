package main.jsonhandler.model;
import static org.junit.jupiter.api.Assertions.*;

public class ErrorEntry {
    private String code;
    private String details;
    private String message;
    private String path;
    private String userMessage;

    public ErrorEntry() {
    }


    public void isAllInitialized() {
        assertNotNull(code);
        assertNotNull(message);
        assertNotNull(userMessage);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
}
