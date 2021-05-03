package main.jsonhandler.model;

public class ParametersRoot {
    private Parameters[] parameters;

    public ParametersRoot() {
    }

    public void isAllInitialized() {
        for (Parameters param : parameters) {
            param.isAllInitialized();
        }
    }

    public Parameters[] getParameters() {
        return parameters;
    }

    public void setParameters(Parameters[] parameters) {
        this.parameters = parameters;
    }
}
