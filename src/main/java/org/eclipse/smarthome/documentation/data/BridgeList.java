/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.eclipse.smarthome.documentation.data;

import org.eclipse.smarthome.documentation.models.Bridge;

/**
 * Created by Alexander on 22.08.2015.
 */
public class BridgeList extends ModelList {
    /**
     * @return Returns a new {@link Bridge} object.
     */
    public Bridge getNewModel() {
        return new Bridge();
    }
}
