package org.openhab.models;

import org.openhab.schemas.thing_description.v1_0.ChannelGroup;

/**
 * Created by Alexander on 21.08.2015.
 */
public class ChannelGroupRef implements Model<ChannelGroup> {
    private ChannelGroup channel;

    public ChannelGroupRef() {

    }

    public ChannelGroupRef(ChannelGroup channel) {
        setModel(channel);
    }

    public ChannelGroup getRealImpl() {
        return channel;
    }

    public void setModel(ChannelGroup channel) {
        this.channel = channel;
    }

    public String id() {
        return channel.getId();
    }

    public String typeId() {
        return channel.getTypeId();
    }
}
