package org.openhab.data;

import org.openhab.models.ChannelGroupRef;

/**
 * Created by Alexander on 23.08.2015.
 */
public class ChannelGroupRefList extends ModelList {
    public ChannelGroupRef getNewModel() {
        return new ChannelGroupRef();
    }
}
