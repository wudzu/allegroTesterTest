package main.jsonhandler.model;
import static org.junit.jupiter.api.Assertions.*;

public class ParameterOptions {
    private Boolean variantsAllowed;
    private Boolean variantsEqual;
    private String ambiguousValueId;
    private String dependsOnParameterId;
    private String[] requiredDependsOnValueIds;
    private String[] displayDependsOnValueIds;
    private Boolean describesProduct;
    private Boolean customValuesEnabled;

    public ParameterOptions() {
    }

    public void isAllInitialized(String type, boolean required) {
        assertNotNull(variantsAllowed);
        assertNotNull(variantsEqual);
        if (type.equals("dictionary") == false) {
            assertNull(ambiguousValueId);
        }
        assertNotNull(describesProduct);
        assertNotNull(customValuesEnabled);

        if (requiredDependsOnValueIds != null) {
            for (String value : requiredDependsOnValueIds) {
                assertTrue(value.startsWith(dependsOnParameterId));
            }
        }
        if (displayDependsOnValueIds != null) {
            for (String value : displayDependsOnValueIds) {
                assertTrue(value.startsWith(dependsOnParameterId));
            }
        }
    }

    public Boolean getVariantsAllowed() {
        return variantsAllowed;
    }

    public void setVariantsAllowed(Boolean variantsAllowed) {
        this.variantsAllowed = variantsAllowed;
    }

    public Boolean getVariantsEqual() {
        return variantsEqual;
    }

    public void setVariantsEqual(Boolean variantsEqual) {
        this.variantsEqual = variantsEqual;
    }

    public String getAmbiguousValueId() {
        return ambiguousValueId;
    }

    public void setAmbiguousValueId(String ambiguousValueId) {
        this.ambiguousValueId = ambiguousValueId;
    }

    public String getDependsOnParameterId() {
        return dependsOnParameterId;
    }

    public void setDependsOnParameterId(String dependsOnParameterId) {
        this.dependsOnParameterId = dependsOnParameterId;
    }

    public String[] getRequiredDependsOnValueIds() {
        return requiredDependsOnValueIds;
    }

    public void setRequiredDependsOnValueIds(String[] requiredDependsOnValueIds) {
        this.requiredDependsOnValueIds = requiredDependsOnValueIds;
    }

    public String[] getDisplayDependsOnValueIds() {
        return displayDependsOnValueIds;
    }

    public void setDisplayDependsOnValueIds(String[] displayDependsOnValueIds) {
        this.displayDependsOnValueIds = displayDependsOnValueIds;
    }

    public Boolean getDescribesProduct() {
        return describesProduct;
    }

    public void setDescribesProduct(Boolean describesProduct) {
        this.describesProduct = describesProduct;
    }

    public Boolean getCustomValuesEnabled() {
        return customValuesEnabled;
    }

    public void setCustomValuesEnabled(Boolean customValuesEnabled) {
        this.customValuesEnabled = customValuesEnabled;
    }
}
