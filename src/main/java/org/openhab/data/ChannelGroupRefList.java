package org.openhab.data;

import org.openhab.models.ChannelGroupRef;

/**
 * Created by Alexander on 23.08.2015.
 */
public class ChannelGroupRefList extends ModelList {
    /**
     * @return Returns a new {@link ChannelGroupRef} object.
     */
    public ChannelGroupRef getNewModel() {
        return new ChannelGroupRef();
    }
}
