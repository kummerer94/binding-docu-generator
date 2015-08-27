/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.openhab.models;

public class Option implements Model<org.openhab.schemas.thing_description.v1_0.Option> {
    /**
     * The original instance from the XML parser.
     */
    private org.openhab.schemas.thing_description.v1_0.Option option;

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
    public Option(org.openhab.schemas.thing_description.v1_0.Option option) {
        setModel(option);
    }

    /**
     * @return The original instance from the XML parser.
     */
    public org.openhab.schemas.thing_description.v1_0.Option getRealImpl() {
        return option;
    }

    /**
     * Set the model.
     *
     * @param option The instance from the XML parser.
     */
    public void setModel(org.openhab.schemas.thing_description.v1_0.Option option) {
        this.option = option;
    }

    /**
     * @return Value of the option.
     */
    public String value() {
        return option.getValue();
    }
}
