package main.jsonhandler.model;
import static org.junit.jupiter.api.Assertions.*;

public class ParameterDictionaryEntry {
    private String id;
    private String value;
    private String[] dependsOnValueIds;

    public ParameterDictionaryEntry() {
    }

    public void isAllInitialized() {
        assertNotNull(id);
        assertNotNull(value);
        for (String entry : dependsOnValueIds) {
            assertNotNull(entry);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String[] getDependsOnValueIds() {
        return dependsOnValueIds;
    }

    public void setDependsOnValueIds(String[] dependsOnValueIds) {
        this.dependsOnValueIds = dependsOnValueIds;
    }
}
