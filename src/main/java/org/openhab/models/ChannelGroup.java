/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.openhab.models;

import org.openhab.data.ChannelRefList;
import org.openhab.schemas.thing_description.v1_0.ChannelGroupType;

/**
 * Created by Alexander on 22.08.2015.
 *
 * Wrapper class to not fully depend on the existing models.
 */
public class ChannelGroup implements Model<org.openhab.schemas.thing_description.v1_0.ChannelGroupType> {
    /**
     * The attribute holding the original instance from the XML parser.
     */
    protected ChannelGroupType channel;

    /**
     * Default constructor.
     */
    public ChannelGroup() {
    }

    /**
     * Constructor.
     *
     * @param channel The instance from the XML parser.
     */
    public ChannelGroup(ChannelGroupType channel) {
        setModel(channel);
    }

    /**
     * @return The original instance from the XML parser.
     */
    public ChannelGroupType getRealImpl() {
        return channel;
    }

    /**
     * Set the model.
     *
     * @param channel The original instance from the XML parser.
     */
    public void setModel(ChannelGroupType channel) {
        this.channel = channel;
    }

    /**
     * @return Id of the channel.
     */
    public String id() {
        return channel.getId();
    }

    /**
     * @return Description of the channel.
     */
    public String description() {
        return channel.getDescription();
    }

    /**
     * @return Label of the channel.
     */
    public String label() {
        return channel.getLabel();
    }

    /**
     * @return All the channel associated with this group.
     */
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
