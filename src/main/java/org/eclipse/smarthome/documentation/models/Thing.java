/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.eclipse.smarthome.documentation.models;

import org.eclipse.smarthome.documentation.data.ChannelGroupRefList;
import org.eclipse.smarthome.documentation.data.ChannelRefList;
import org.eclipse.smarthome.documentation.schemas.thing_description.v1_0.Channel;
import org.eclipse.smarthome.documentation.schemas.thing_description.v1_0.ChannelGroup;
import org.eclipse.smarthome.documentation.schemas.thing_description.v1_0.ThingType;

/**
 * Created by Alexander on 21.08.2015.
 * <p/>
 * Wrapper class to not fully depend on the existing models.
 */
public class Thing implements Model<ThingType> {
    /**
     * The instance from the XML parser.
     */
    protected ThingType thing;

    /**
     * Default constructor.
     */
    public Thing() {
    }

    /**
     * Constructor.
     *
     * @param type Original instance from the XML parser.
     */
    public Thing(ThingType type) {
        setModel(type);
    }

    /**
     * @return The instance from the XML parser.
     */
    public ThingType getRealImpl() {
        return thing;
    }

    /**
     * Set the model.
     *
     * @param type Original instance from the XML parser.
     */
    public void setModel(ThingType type) {
        this.thing = type;
    }

    /**
     * @return Id of the thing.
     */
    public String id() {
        return thing.getId();
    }

    /**
     * @return Label of the thing.
     */
    public String label() {
        return thing.getLabel();
    }

    /**
     * @return Description of the thing.
     */
    public String description() {
        return thing.getDescription();
    }

    /**
     * @return Configuration reference of the thing.
     */
    public String configDescriptionRef() {
        if (thing.getConfigDescriptionRef() != null) {
            return thing.getConfigDescriptionRef().getUri();
        } else {
            return "";
        }
    }

    /**
     * @return A list of channels.
     */
    public ChannelRefList channels() {
        ChannelRefList channelRefs = new ChannelRefList();
        if (thing.getChannels() != null) {
            for (Channel channel : thing.getChannels().getChannel()) {
                channelRefs.put(channel);
            }
        }
        return channelRefs;
    }

    /**
     * @return A list of channel groups.
     */
    public ChannelGroupRefList channelGroups() {
        ChannelGroupRefList channels = new ChannelGroupRefList();
        if (thing.getChannelGroups() != null) {
            for (ChannelGroup group : thing.getChannelGroups().getChannelGroup()) {
                channels.put(group);
            }
        }
        return channels;
    }

    /**
     * @return The configuration for the thing.
     */
    public ConfigDescription configDescriptions() {
        if (thing.getConfigDescription() != null) {
            return new ConfigDescription(thing.getConfigDescription());
        } else {
            return null;
        }
    }


}
