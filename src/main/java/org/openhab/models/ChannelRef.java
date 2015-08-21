package org.openhab.models;

/**
 * Created by Alexander on 21.08.2015.
 */
public class ChannelRef {

    private org.openhab.schemas.thing_description.v1_0.Channel channel;

    public ChannelRef(org.openhab.schemas.thing_description.v1_0.Channel channel) {
        this.channel = channel;
    }

    public String id() {
        return channel.getId();
    }

    public String typeId() {
        return channel.getTypeId();
    }
}
