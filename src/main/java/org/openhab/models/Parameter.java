package org.openhab.models;

import org.openhab.Utils;
import org.openhab.data.OptionList;

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

    public org.openhab.schemas.config_description.v1_0.Parameter getRealImpl() {
        return parameter;
    }

    public void setModel(org.openhab.schemas.config_description.v1_0.Parameter parameter) {
        this.parameter = parameter;
    }

    public String type() {
        return parameter.getType().toString();
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

    public Boolean readOnly() {
        return parameter.isReadOnly();
    }

    public String isReadOnly() {
        return Utils.trueOrFalse(readOnly());
    }

    public Boolean required() {
        return parameter.isRequired();
    }

    public String isRequired() {
        return Utils.trueOrFalse(required());
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

    public OptionList options() {
        OptionList optionList = new OptionList();
        if (parameter.getOptions() != null) {
            for (org.openhab.schemas.config_description.v1_0.OptionsType.Option option : parameter.getOptions().getOption()) {
                optionList.put(option);
            }
        }
        return optionList;
    }

    public String pattern() {
        return parameter.getPattern();
    }
}
