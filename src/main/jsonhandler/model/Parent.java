package main.jsonhandler.model;
import static org.junit.jupiter.api.Assertions.*;

public class Parent {
    private String id;

    public Parent() {
    }

    public void isAllInitialized() {
        assertNotNull(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
