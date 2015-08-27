/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.openhab.models;

import org.openhab.Utils;
import org.openhab.data.OptionList;

import java.math.BigDecimal;


public class Parameter implements Model<org.openhab.schemas.config_description.v1_0.Parameter> {
    /**
     * Instance from the XML parser.
     */
    protected org.openhab.schemas.config_description.v1_0.Parameter parameter;

    /**
     * Default constructor.
     */
    public Parameter() {
    }

    /**
     * Constructor.
     *
     * @param parameter Instance from the XML parser.
     */
    public Parameter(org.openhab.schemas.config_description.v1_0.Parameter parameter) {
        setModel(parameter);
    }

    /**
     * @return The original instance from the XML parser.
     */
    public org.openhab.schemas.config_description.v1_0.Parameter getRealImpl() {
        return parameter;
    }

    /**
     * Set the model.
     *
     * @param parameter The instance from the XML parser.
     */
    public void setModel(org.openhab.schemas.config_description.v1_0.Parameter parameter) {
        this.parameter = parameter;
    }

    /**
     * @return Type of the parameter.
     */
    public String type() {
        return parameter.getType().toString();
    }

    /**
     * @return Name of the parameter.
     */
    public String name() {
        return parameter.getName();
    }

    /**
     * @return Label of the parameter.
     */
    public String label() {
        return parameter.getLabel();
    }

    /**
     * @return Description of the parameter.
     */
    public String description() {
        return parameter.getDescription();
    }

    /**
     * @return Whether the parameter is readonly.
     */
    public Boolean readOnly() {
        return parameter.isReadOnly();
    }

    /**
     * Wrapper method for mustache.
     * @return "True" if it is readonly, "False" if not.
     */
    public String isReadOnly() {
        return Utils.trueOrFalse(readOnly());
    }

    /**
     * @return Whether the parameter is required.
     */
    public Boolean required() {
        return parameter.isRequired();
    }

    /**
     * @return "True" if it is required, "False" if not.
     */
    public String isRequired() {
        return Utils.trueOrFalse(required());
    }

    /**
     * @return The default value of the parameter.
     */
    public String defaultValue() {
        return parameter.getDefault();
    }

    /**
     * @return The minimal value of the parameter.
     */
    public BigDecimal min() {
        return parameter.getMin();
    }

    /**
     * @return The maximal value of the parameter.
     */
    public BigDecimal max() {
        return parameter.getMax();
    }

    /**
     * @return The step in between the values for this parameter.
     */
    public BigDecimal step() {
        return parameter.getStep();
    }

    /**
     * @return A list of options.
     */
    public OptionList options() {
        OptionList optionList = new OptionList();
        if (parameter.getOptions() != null) {
            for (org.openhab.schemas.config_description.v1_0.OptionsType.Option option : parameter.getOptions().getOption()) {
                optionList.put(option);
            }
        }
        return optionList;
    }

    /**
     * @return The parameter of the parameter.
     */
    public String pattern() {
        return parameter.getPattern();
    }
}
