package org.openhab.models;

import org.openhab.data.ChannelRefList;
import org.openhab.schemas.thing_description.v1_0.ChannelGroupType;

/**
 * Created by Alexander on 22.08.2015.
 *
 * Wrapper class to not fully depend on the existing models.
 */
public class ChannelGroup implements Model<org.openhab.schemas.thing_description.v1_0.ChannelGroupType> {
    protected ChannelGroupType channel;

    public ChannelGroup() {

    }

    public ChannelGroup(ChannelGroupType channel) {
        setModel(channel);
    }

    public ChannelGroupType getRealImpl() {
        return channel;
    }

    public void setModel(ChannelGroupType channel) {
        this.channel = channel;
    }

    public String id() {
        return channel.getId();
    }

    public String description() {
        return channel.getDescription();
    }

    public String label() {
        return channel.getLabel();
    }

    public ChannelRefList channels() {
        ChannelRefList channelRefs = new ChannelRefList();
        if (channel.getChannels() != null) {
            for (org.openhab.schemas.thing_description.v1_0.Channel ch : channel.getChannels().getChannel()) {
                channelRefs.put(ch);
            }
        }
        return channelRefs;
    }


}
