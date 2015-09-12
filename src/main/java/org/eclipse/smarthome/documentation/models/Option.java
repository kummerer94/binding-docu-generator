/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.eclipse.smarthome.documentation.models;

public class Option implements Model<org.eclipse.smarthome.documentation.schemas.thing_description.v1_0.Option> {
    /**
     * The original instance from the XML parser.
     */
    private org.eclipse.smarthome.documentation.schemas.thing_description.v1_0.Option option;

    /**
     * Default constructor.
     */
    public Option() {
    }

    /**
     * Constructor.
     *
     * @param option The instance from the XML parser.
     */
    public Option(org.eclipse.smarthome.documentation.schemas.thing_description.v1_0.Option option) {
        setModel(option);
    }

    /**
     * @return The original instance from the XML parser.
     */
    public org.eclipse.smarthome.documentation.schemas.thing_description.v1_0.Option getRealImpl() {
        return option;
    }

    /**
     * Set the model.
     *
     * @param option The instance from the XML parser.
     */
    public void setModel(org.eclipse.smarthome.documentation.schemas.thing_description.v1_0.Option option) {
        this.option = option;
    }

    /**
     * @return Value of the option.
     */
    public String value() {
        return option.getValue();
    }
}
