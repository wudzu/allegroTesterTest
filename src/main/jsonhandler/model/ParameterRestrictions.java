package main.jsonhandler.model;
import static org.junit.jupiter.api.Assertions.*;

public class ParameterRestrictions {
    private Integer min;
    private Integer max;
    private Integer minLength;
    private Integer maxLength;
    private Boolean multipleChoices;
    private Boolean range;
    private Integer allowedNumberOfValues;
    private Integer precision;

    public ParameterRestrictions() {
    }

    public void isAllInitialized(String type) {
        if (type.equals("integer")) {
            assertNotNull(min);
            assertNotNull(max);
            assertNotNull(range);
        } else if (type.equals("float")) {
            assertNotNull(min);
            assertNotNull(max);
            assertNotNull(range);
            assertNotNull(precision);
            assertTrue(precision >= 0);
        } else if (type.equals("string")) {
            assertNotNull(minLength);
            assertNotNull(maxLength);
            assertNotNull(allowedNumberOfValues);
            assertTrue(allowedNumberOfValues >= 0);
        } else if (type.equals("dictionary")) {
            assertNotNull(multipleChoices);
        }
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Boolean getMultipleChoices() {
        return multipleChoices;
    }

    public void setMultipleChoices(Boolean multipleChoices) {
        this.multipleChoices = multipleChoices;
    }

    public Boolean getRange() {
        return range;
    }

    public void setRange(Boolean range) {
        this.range = range;
    }

    public Integer getAllowedNumberOfValues() {
        return allowedNumberOfValues;
    }

    public void setAllowedNumberOfValues(Integer allowedNumberOfValues) {
        this.allowedNumberOfValues = allowedNumberOfValues;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }
}
