package org.openhab.data;

import org.openhab.models.ChannelGroup;

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
