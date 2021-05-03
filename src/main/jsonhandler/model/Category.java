package main.jsonhandler.model;
import static org.junit.jupiter.api.Assertions.*;

public class Category {
    private String id;
    private Boolean leaf;
    private String name;
    private Options options;
    private Parent parent;

    public Category() {
    }

    public void isAllInitialized() {
        assertNotNull(id);
        assertNotNull(leaf);
        assertNotNull(name);

        assertNotNull(options);
        if (options != null ) {
            options.isAllInitialized();
        }
        if (parent != null) {
            parent.isAllInitialized();
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
