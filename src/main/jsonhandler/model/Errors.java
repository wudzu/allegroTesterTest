package main.jsonhandler.model;

public class Errors {
    private ErrorEntry[] errors;

    public Errors() {
    }


    public void isAllInitialized() {
        for (ErrorEntry entry : errors) {
            entry.isAllInitialized();
        }
    }

    public ErrorEntry[] getErrors() {
        return errors;
    }

    public void setErrors(ErrorEntry[] errors) {
        this.errors = errors;
    }
}
