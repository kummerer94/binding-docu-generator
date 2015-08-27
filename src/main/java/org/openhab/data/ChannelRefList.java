/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.openhab.data;

import org.openhab.models.ChannelRef;

/**
 * Created by Alexander on 23.08.2015.
 */
public class ChannelRefList extends ModelList {
    /**
     * @return Returns a new {@link ChannelRef} object.
     */
    public ChannelRef getNewModel() {
        return new ChannelRef();
    }
}
