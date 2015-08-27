/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.openhab.models;

import org.openhab.data.ParameterList;
import org.openhab.schemas.config_description.v1_0.Parameter;

public class ConfigDescription implements Model<org.openhab.schemas.config_description.v1_0.ConfigDescription> {
    /**
     * The original instance from the XML parser.
     */
    protected org.openhab.schemas.config_description.v1_0.ConfigDescription config;

    /**
     * Default constructor.
     */
    public ConfigDescription() {
    }

    /**
     * Constructor.
     *
     * @param config The instance from the XML parser.
     */
    public ConfigDescription(org.openhab.schemas.config_description.v1_0.ConfigDescription config) {
        setModel(config);
    }

    /**
     * @return The instance from the XML parser.
     */
    public org.openhab.schemas.config_description.v1_0.ConfigDescription getRealImpl() {
        return config;
    }

    /**
     * Set the model.
     *
     * @param config The instance from the XML parser.
     */
    public void setModel(org.openhab.schemas.config_description.v1_0.ConfigDescription config) {
        this.config = config;
    }

    /**
     * @return The URI of the configuration.
     */
    public String uri() {
        return config.getUri();
    }

    /**
     * @return A list of parameters.
     */
    public ParameterList parameter() {
        ParameterList parameterList = new ParameterList();
        for (Parameter param : config.getParameter()) {
            parameterList.put(param);
        }
        return parameterList;
    }
}
