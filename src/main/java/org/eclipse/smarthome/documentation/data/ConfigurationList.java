/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.eclipse.smarthome.documentation.data;

import org.eclipse.smarthome.documentation.models.ConfigDescription;

/**
 * Created by Alexander on 22.08.2015.
 */
public class ConfigurationList extends ModelList {
    /**
     * @return Returns a new {@link ConfigDescription} object.
     */
    public ConfigDescription getNewModel() {
        return new ConfigDescription();
    }
}
