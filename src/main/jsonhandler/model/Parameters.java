package main.jsonhandler.model;
import static org.junit.jupiter.api.Assertions.*;

public class Parameters {
    private String id;
    private String name;
    private String type;
    private Boolean required;
    private Boolean requiredForProduct;
    private String unit;
    private ParameterOptions options;
    private ParameterRestrictions restrictions;
    private ParameterDictionaryEntry[] dictionary;

    public Parameters() {
    }

    public void isAllInitialized() {
        assertNotNull(id);
        assertNotNull(name);
        assertNotNull(type);
        assertNotNull(required);
        assertNotNull(requiredForProduct);
        assertNotNull(id);
        options.isAllInitialized(type, required);
        options.isAllInitialized(type, required);
        restrictions.isAllInitialized(type);
        if (type.equals("dictionary") == false) {
            assertNull(dictionary);
        } else {
            assertNotNull(dictionary);

            for (ParameterDictionaryEntry entry : dictionary) {
                entry.isAllInitialized();
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getRequiredForProduct() {
        return requiredForProduct;
    }

    public void setRequiredForProduct(Boolean requiredForProduct) {
        this.requiredForProduct = requiredForProduct;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ParameterOptions getOptions() {
        return options;
    }

    public void setOptions(ParameterOptions options) {
        this.options = options;
    }

    public ParameterRestrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(ParameterRestrictions restrictions) {
        this.restrictions = restrictions;
    }

    public ParameterDictionaryEntry[] getDictionary() {
        return dictionary;
    }

    public void setDictionary(ParameterDictionaryEntry[] dictionary) {
        this.dictionary = dictionary;
    }
}
