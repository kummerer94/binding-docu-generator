/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.openhab;

import org.apache.commons.lang3.StringUtils;
import org.openhab.schemas.config_description.v1_0.ConfigDescription;
import org.openhab.schemas.config_description.v1_0.Parameter;
import org.openhab.schemas.thing_description.v1_0.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexander on 18.08.2015.
 */
public class MarkdownProvider {

    private final static String[] CHANNEL_TYPE_HEADER = {"Channel Type Id", "Item Type", "ReadOnly", "Options", "Description"};
    private final static String CHANNEL_TYPE_TITLE = "Channels";
    private final static String[] CHANNEL_GROUP_TYPE_HEADER = {"Channel Group Type Id", "Channels", "Description"};
    private final static String CHANNEL_GROUP_TITLE = "Channel Groups";
    private final static String[] THING_TYPE_HEADER = {"Thing Type Id", "Channel Groups", "Config", "Description"};
    private final static String THING_TYPE_TITLE = "Things";
    private final static String[] BRIDGE_TYPE_HEADER = {"Bridge Type Id", "Channel Groups", "Channels", "Description"};
    private final static String BRIDGE_TYPE_TITLE = "Bridges";
    private final static String[] CONFIG_HEADER = {"Name", "Type", "Properties", "Context", "Description"};
    private final static String BRIDGE_CONFIG_TITLE = "Configuration for bridge: ";
    private final static String THING_CONFIG_TITLE = "Configuration for thing. ";
    private final static String CONFIG_DESC_TITLE = "Config descriptions";
    public static final String TABLE_DIVIDER = "|";

    /**
     * Returns the header for the markdown file.
     *
     * @return
     */
    public static String getHeader() {
        return "# Generated documentation \n\n\n";
    }

    /**
     * Returns a markdown table header for a list of column names.
     *
     * @param cols
     * @return
     */
    private static StringBuilder getTableHeader(List<String> cols) {
        StringBuilder builder = new StringBuilder(TABLE_DIVIDER);
        for (String col : cols) {
            builder.append(col).append(TABLE_DIVIDER);
        }
        builder.append("\n").append('|').append(StringUtils.repeat("---" + TABLE_DIVIDER, cols.size())).append("\n");
        return builder;
    }

    /**
     * Returns a markdown table header for a list of column names with a header.
     *
     * @param title
     * @param cols
     * @return
     */
    private static StringBuilder getTableHeader(String title, List<String> cols) {
        return getTableHeader(cols).insert(0, "## " + title + "\n\n");
    }

    /**
     * Takes the options and parses them to a string list.
     *
     * @param options
     * @return
     */
    private static StringBuilder optionsToString(Options options) {
        StringBuilder builder = new StringBuilder();
        if (options == null) {
            return builder;
        }
        for (Option opt : options.getOption()) {
            builder.append(opt.getValue()).append(", ");
        }
        // Remove trailing ","
        builder.deleteCharAt(builder.lastIndexOf(","));
        return builder;
    }

    /**
     * Takes channels and parses them to a string list.
     *
     * @param channels
     * @return
     */
    private static StringBuilder channelsToString(Channels channels) {
        StringBuilder builder = new StringBuilder();
        if (channels == null) {
            return builder;
        }
        for (Channel channel : channels.getChannel()) {
            builder.append(link(channel.getId(), "#channel-id-" + channel.getTypeId())).append(", ");
        }
        // Remove trailing ","
        builder.deleteCharAt(builder.lastIndexOf(","));
        return builder;
    }

    /**
     * Takes the channel groups and parses them to a string list.
     *
     * @param groups
     * @return
     */
    private static StringBuilder channelGroupsToString(ChannelGroups groups) {
        StringBuilder builder = new StringBuilder();
        if (groups == null) {
            return builder;
        }
        for (ChannelGroup group : groups.getChannelGroup()) {
            builder.append(link(group.getId(), "#channel-group-id-" + group.getTypeId())).append(", ");
        }
        // Remove trailing ","
        builder.deleteCharAt(builder.lastIndexOf(","));
        return builder;
    }

    /**
     * Creates a string for the properties in a ConfigDescription.
     *
     * @param param
     * @return
     */
    private static StringBuilder propertiesToString(Parameter param) {
        StringBuilder builder = new StringBuilder();
        builder.append("required=").append(trueOrFalse(param.isRequired())).append(", ")
                .append("readOnly=").append(trueOrFalse(param.isReadOnly())).append(", ");
        appendNotNull(builder, "max=", param.getMax()).append(", ");
        appendNotNull(builder, "min=", param.getMin()).append(", ");
        appendNotNull(builder, "step=", param.getStep()).append(", ");
        appendNotNull(builder, "pattern=", param.getPattern()).append(", ");
        builder.delete(builder.length() - 2, builder.length() - 1);
        return builder;
    }

    /**
     * Creates the markdown for a given configuration.
     *
     * @param builder
     * @param config
     * @return
     */
    private static StringBuilder configToString(StringBuilder builder, ConfigDescription config) {
        for (Parameter param : config.getParameter()) {
            builder.append(TABLE_DIVIDER)
                    .append(param.getName()).append(TABLE_DIVIDER)
                    .append(param.getType()).append(TABLE_DIVIDER)
                    .append(propertiesToString(param)).append(TABLE_DIVIDER)
                    .append(((param.getContext() != null) ? param.getContext() : "default")).append(TABLE_DIVIDER)
                    .append(sanitize(param.getDescription())).append(TABLE_DIVIDER).append("\n");
        }
        return builder;
    }

    /**
     * Returns true or false as String for the expression given.
     *
     * @param expr
     * @return
     */
    private static String trueOrFalse(Boolean expr) {
        return (expr != null && expr) ? "true" : "false";
    }

    /**
     * Creates a markdown link.
     *
     * @param title
     * @param url
     * @return
     */
    private static String link(String title, String url) {
        return String.format("[%s](%s)", title, url);
    }

    /**
     * Shortcut.
     *
     * @param title
     * @return
     */
    private static String link(String title) {
        return link(title, title);
    }

    /**
     * Append the text to the StringBuilder if object is not null.
     * If {@param append} is null it will give back a new StringBuilder instance. Thus you can still append something
     * to the returned StringBuilder but it will only be effective if {@param append} is not null.
     *
     * @param builder
     * @param text
     * @param append
     * @return
     */
    private static StringBuilder appendNotNull(StringBuilder builder, String text, Object append) {
        if (append != null) {
            builder.append(text).append(append);
            return builder;
        }
        return new StringBuilder();
    }

    /**
     * Sanitizes a string for the markdown table.
     *
     * @param s
     * @return
     */
    private static String sanitize(String s) {
        return s.replaceAll("\\r\\n|\\r|\\n", " ");
    }


    ////////////////////////////////////
    //      MARKDOWN GENERATION       //
    ///////////////////////////////////

    /**
     * Creates the markdown for the channel types.
     *
     * @param channels
     * @return
     */
    public static String handleChannelTypes(List<ChannelType> channels) {
        StringBuilder builder = new StringBuilder(getTableHeader(CHANNEL_TYPE_TITLE, Arrays.asList(CHANNEL_TYPE_HEADER)));
        for (ChannelType channel : channels) {
            builder.append(TABLE_DIVIDER)
                    // Add anchor for channel id
                    .append("<a name=\"channel-id-").append(channel.getId()).append("\"></a>")
                    .append(channel.getId()).append(TABLE_DIVIDER)
                    .append(channel.getItemType()).append(TABLE_DIVIDER)
                    .append((channel.getState().isReadOnly()) ? "Yes" : "No").append(TABLE_DIVIDER)
                    .append(optionsToString(channel.getState().getOptions())).append(TABLE_DIVIDER)
                    .append(sanitize(channel.getDescription())).append(TABLE_DIVIDER).append("\n");
        }
        return builder.toString();
    }

    /**
     * Creates the markdown for the thing types.
     *
     * @param things
     * @return
     */
    public static String handleThingTypes(List<ThingType> things) {
        StringBuilder builder = new StringBuilder(getTableHeader(THING_TYPE_TITLE, Arrays.asList(THING_TYPE_HEADER)));
        for (ThingType thing : things) {
            builder.append(TABLE_DIVIDER).append(thing.getId()).append(TABLE_DIVIDER)
                    .append(channelGroupsToString(thing.getChannelGroups())).append(TABLE_DIVIDER)
                    .append((thing.getConfigDescriptionRef() != null) ? link(thing.getConfigDescriptionRef().getUri(), "#config-desc-" + thing.getConfigDescriptionRef().getUri()) : "").append(TABLE_DIVIDER)
                    .append(sanitize(thing.getDescription())).append(TABLE_DIVIDER).append("\n");
        }
        return builder.toString();
    }

    /**
     * Creates the markdown for the channel group types.
     *
     * @param channels
     * @return
     */
    public static String handleChannelGroupTypes(List<ChannelGroupType> channels) {
        StringBuilder builder = new StringBuilder(getTableHeader(CHANNEL_GROUP_TITLE, Arrays.asList(CHANNEL_GROUP_TYPE_HEADER)));
        for (ChannelGroupType channel : channels) {
            builder.append(TABLE_DIVIDER)
                    // Add anchor for channel group id
                    .append("<a name=\"channel-group-id-" + channel.getId() + "\"></a>")
                    .append(channel.getId()).append(TABLE_DIVIDER)
                    .append(channelsToString(channel.getChannels())).append(TABLE_DIVIDER)
                    .append(sanitize(channel.getDescription())).append(TABLE_DIVIDER).append("\n");
        }
        return builder.toString();
    }

    /**
     * Creates the markdown for the bridges.
     *
     * @param bridges
     * @return
     */
    public static String handleBridgeTypes(List<BridgeType> bridges) {
        StringBuilder builder = new StringBuilder(getTableHeader(BRIDGE_TYPE_TITLE, Arrays.asList(BRIDGE_TYPE_HEADER)));
        for (BridgeType bridge : bridges) {
            builder.append(TABLE_DIVIDER)
                    // Add anchor for bridge id
                    .append("<a name=\"bridge-id-" + bridge.getId() + "\"></a>")
                    .append(bridge.getId()).append(TABLE_DIVIDER)
                    .append(channelGroupsToString(bridge.getChannelGroups())).append(TABLE_DIVIDER)
                    .append(channelsToString(bridge.getChannels())).append(TABLE_DIVIDER)
                    .append(sanitize(bridge.getDescription())).append(TABLE_DIVIDER).append("\n");
        }
        return builder.toString();
    }

    /**
     * Creates the markdown for the configuration of the bridges.
     *
     * @param bridges
     * @return
     */
    public static String handleBridgeConfig(List<BridgeType> bridges) {
        StringBuilder builder = new StringBuilder();
        for (BridgeType bridge : bridges) {
            if (bridge.getConfigDescription() != null && bridge.getConfigDescription().getParameter().size() > 0) {
                builder.append(getTableHeader(BRIDGE_CONFIG_TITLE + bridge.getId(), Arrays.asList(CONFIG_HEADER)));
                configToString(builder, bridge.getConfigDescription());
            }
        }
        return builder.toString();
    }

    /**
     * Creates the markdown for the config of the things.
     *
     * @param things
     * @return
     */
    public static String handleThingConfig(List<ThingType> things) {
        StringBuilder builder = new StringBuilder();
        for (ThingType thing : things) {
            if (thing.getConfigDescription() != null && thing.getConfigDescription().getParameter().size() > 0) {
                builder.append(getTableHeader(THING_CONFIG_TITLE + thing.getId(), Arrays.asList(CONFIG_HEADER)));
                configToString(builder, thing.getConfigDescription());
            }
        }
        return builder.toString();
    }

    /**
     * Creates the markdown for the given config descriptions.
     *
     * @param configs
     * @return
     */
    public static String handleConfigDescriptions(List<ConfigDescription> configs) {
        StringBuilder builder = new StringBuilder("## " + CONFIG_DESC_TITLE).append("\n\n");
        for (ConfigDescription config : configs) {
            if (config.getParameter() != null && config.getParameter().size() > 0) {
                // Add anchor
                builder.append("## ").append(config.getUri()).append("<a name=\"config-desc-").append(config.getUri()).append("\"></a> \n\n");
                builder.append(getTableHeader(Arrays.asList(CONFIG_HEADER)));
                configToString(builder, config);
            }
        }
        return builder.toString();
    }

}
