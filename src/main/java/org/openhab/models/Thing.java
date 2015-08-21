package org.openhab.models;

import org.openhab.schemas.thing_description.v1_0.Channel;
import org.openhab.schemas.thing_description.v1_0.ChannelGroup;
import org.openhab.schemas.thing_description.v1_0.ThingType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 21.08.2015.
 * <p/>
 * Wrapper class to not fully depend on the existing models.
 */
public class Thing {
    protected ThingType thing;

    public Thing(ThingType type) {
        this.thing = type;
    }

    public String id() {
        return thing.getId();
    }

    public String label() {
        return thing.getLabel();
    }

    public String description() {
        return thing.getDescription();
    }


    public String configDescriptionRef() {
        if (thing.getConfigDescriptionRef() != null) {
            return thing.getConfigDescriptionRef().getUri();
        } else {
            return "";
        }
    }

    public List<ChannelRef> channels() {
        List<ChannelRef> channelRefs = new ArrayList<ChannelRef>();
        if (thing.getChannels() != null) {
            for (Channel channel : thing.getChannels().getChannel()) {
                channelRefs.add(new ChannelRef(channel));
            }
        }
        return channelRefs;
    }


    public List<ChannelGroupRef> channelGroups() {
        List<ChannelGroupRef> channels = new ArrayList<ChannelGroupRef>();
        if (thing.getChannelGroups() != null) {
            for (ChannelGroup group : thing.getChannelGroups().getChannelGroup()) {
                channels.add(new ChannelGroupRef(group));
            }
        }
        return channels;
    }

    public org.openhab.models.ConfigDescription configDescriptions() {
        if (thing.getConfigDescription() != null) {
            return new ConfigDescription(thing.getConfigDescription());
        } else {
            return null;
        }
    }


}
