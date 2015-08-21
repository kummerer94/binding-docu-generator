package org.openhab.models;

import org.openhab.schemas.thing_description.v1_0.ChannelType;

/**
 * Created by Alexander on 21.08.2015.
 */
public class Channel {

    protected ChannelType channel;

    public Channel(ChannelType channel) {
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

    public String category() {
        return channel.getCategory();
    }

    public String configDescriptionRef() {
        if (channel.getConfigDescriptionRef() != null) {
            return channel.getConfigDescriptionRef().getUri();
        } else {
            return "";
        }
    }

    public ConfigDescription configDescription() {
        if (channel.getConfigDescription() != null) {
            return new ConfigDescription(channel.getConfigDescription());
        } else {
            return null;
        }
    }
}
