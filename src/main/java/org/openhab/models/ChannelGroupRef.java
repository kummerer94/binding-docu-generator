package org.openhab.models;

/**
 * Created by Alexander on 21.08.2015.
 */
public class ChannelGroupRef {
    private org.openhab.schemas.thing_description.v1_0.ChannelGroup channel;

    public ChannelGroupRef(org.openhab.schemas.thing_description.v1_0.ChannelGroup channel) {
        this.channel = channel;
    }

    public String id() {
        return channel.getId();
    }

    public String typeId() {
        return channel.getTypeId();
    }
}
