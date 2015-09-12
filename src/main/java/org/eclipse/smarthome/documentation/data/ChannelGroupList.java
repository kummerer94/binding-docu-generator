/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.eclipse.smarthome.documentation.data;

import org.eclipse.smarthome.documentation.models.ChannelGroup;

/**
 * Created by Alexander on 22.08.2015.
 */
public class ChannelGroupList extends ModelList {
    /**
     * @return Returns a new {@link ChannelGroup} object.
     */
    public ChannelGroup getNewModel() {
        return new ChannelGroup();
    }
}
