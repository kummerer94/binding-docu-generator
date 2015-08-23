package org.openhab.data;

import org.openhab.models.ChannelGroup;

/**
 * Created by Alexander on 22.08.2015.
 */
public class ChannelGroupList extends ModelList {
    public ChannelGroup getNewModel() {
        return new ChannelGroup();
    }
}
