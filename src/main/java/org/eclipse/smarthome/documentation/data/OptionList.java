/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.eclipse.smarthome.documentation.data;

import org.eclipse.smarthome.documentation.models.Option;

/**
 * Created by Alexander on 26.08.2015.
 */
public class OptionList extends ModelList {
    /**
     * @return Returns a new {@link Option} object.
     */
    public Option getNewModel() {
        return new Option();
    }
}
