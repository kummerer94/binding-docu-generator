package org.openhab.models;

import org.openhab.schemas.thing_description.v1_0.Channel;

/**
 * Created by Alexander on 21.08.2015.
 */
public class ChannelRef implements Model<Channel> {

    private Channel channel;

    public ChannelRef() {

    }

    public ChannelRef(Channel channel) {
        setModel(channel);
    }

    public Channel getType() {
        return channel;
    }

    public void setModel(Channel channel) {
        this.channel = channel;
    }

    public String id() {
        return channel.getId();
    }

    public String typeId() {
        return channel.getTypeId();
    }
}
