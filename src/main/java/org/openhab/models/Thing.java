package org.openhab.models;

import org.openhab.data.ChannelGroupRefList;
import org.openhab.data.ChannelRefList;
import org.openhab.schemas.thing_description.v1_0.Channel;
import org.openhab.schemas.thing_description.v1_0.ChannelGroup;
import org.openhab.schemas.thing_description.v1_0.ThingType;

/**
 * Created by Alexander on 21.08.2015.
 * <p/>
 * Wrapper class to not fully depend on the existing models.
 */
public class Thing implements Model<ThingType> {
    protected ThingType thing;

    public Thing() {
    }

    public Thing(ThingType type) {
        setModel(type);
    }

    public ThingType getRealImpl() {
        return thing;
    }

    public void setModel(ThingType type) {
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

    public ChannelRefList channels() {
        ChannelRefList channelRefs = new ChannelRefList();
        if (thing.getChannels() != null) {
            for (Channel channel : thing.getChannels().getChannel()) {
                channelRefs.put(channel);
            }
        }
        return channelRefs;
    }

    public ChannelGroupRefList channelGroups() {
        ChannelGroupRefList channels = new ChannelGroupRefList();
        if (thing.getChannelGroups() != null) {
            for (ChannelGroup group : thing.getChannelGroups().getChannelGroup()) {
                channels.put(group);
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
