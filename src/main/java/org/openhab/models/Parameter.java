package org.openhab.models;

import java.math.BigDecimal;

/**
 * Created by Alexander on 21.08.2015.
 */
public class Parameter implements Model<org.openhab.schemas.config_description.v1_0.Parameter> {

    protected org.openhab.schemas.config_description.v1_0.Parameter parameter;

    public Parameter() {

    }

    public Parameter(org.openhab.schemas.config_description.v1_0.Parameter parameter) {
        setModel(parameter);
    }

    public org.openhab.schemas.config_description.v1_0.Parameter getType() {
        return parameter;
    }

    public void setModel(org.openhab.schemas.config_description.v1_0.Parameter parameter) {
        this.parameter = parameter;
    }

    public String name() {
        return parameter.getName();
    }

    public String label() {
        return parameter.getLabel();
    }

    public String description() {
        return parameter.getDescription();
    }

    public String defaultValue() {
        return parameter.getDefault();
    }

    public BigDecimal min() {
        return parameter.getMin();
    }

    public BigDecimal max() {
        return parameter.getMax();
    }

    public BigDecimal step() {
        return parameter.getStep();
    }

    public String pattern() {
        return parameter.getPattern();
    }
}
