package org.openhab;

import org.apache.commons.lang3.StringUtils;
import org.openhab.schemas.thing_description.v1_0.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexander on 18.08.2015.
 */
public class MarkdownProvider {

    private final static String[] CHANNEL_TYPE_HEADER = {"Channel Type Id", "Label", "Item Type", "ReadOnly", "Options", "Description"};
    private final static String[] CHANNEL_GROUP_TYPE_HEADER = {"Channel Group Type Id", "Label", "Channels", "Description"};
    private final static String[] THING_TYPE_HEADER = {"Thing Type Id", "Label", "Description"};
    public static final String TABLE_DIVIDER = "|";

    /**
     * Returns the header for the markdown file.
     *
     * @return
     */
    public static String getHeader() {
        return "# Generated documentation \n\n\n";
    }
    private static StringBuilder getTableHeader(List<String> cols) {
        StringBuilder builder = new StringBuilder(TABLE_DIVIDER);
        for (String col : cols) {
            builder.append(col).append(TABLE_DIVIDER);
        }
        builder.append("\n").append('|').append(StringUtils.repeat("---" + TABLE_DIVIDER, cols.size())).append("\n");
        return builder;
    }

    private static StringBuilder optionsToString(Options options) {
        StringBuilder builder = new StringBuilder(" ");
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

    private static StringBuilder channelsToString(Channels channels) {
        StringBuilder builder = new StringBuilder(" ");
        if (channels == null) {
            return builder;
        }
        for (Channel channel : channels.getChannel()) {
            builder.append(channel.getId()).append(", ");
        }
        // Remove trailing ","
        builder.deleteCharAt(builder.lastIndexOf(","));
        return builder;
    }

    /**
     * Creates the markdown for the channel types.
     *
     * @param channels
     * @return
     */
    public static String handleChannelTypes(List<ChannelType> channels) {
        StringBuilder builder = new StringBuilder(getTableHeader(Arrays.asList(CHANNEL_TYPE_HEADER)));
        for (ChannelType channel : channels) {
            builder.append(TABLE_DIVIDER).append(channel.getId()).append(TABLE_DIVIDER)
                    .append(channel.getLabel()).append(TABLE_DIVIDER)
                    .append(channel.getItemType()).append(TABLE_DIVIDER)
                    .append((channel.getState().isReadOnly()) ? "Yes" : "No").append(TABLE_DIVIDER)
                    .append(optionsToString(channel.getState().getOptions())).append(TABLE_DIVIDER)
                    .append(channel.getDescription()).append(TABLE_DIVIDER).append("\n");
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
        StringBuilder builder = new StringBuilder(getTableHeader(Arrays.asList(THING_TYPE_HEADER)));

        for (ThingType thing : things) {
            builder.append(TABLE_DIVIDER).append(thing.getId()).append(TABLE_DIVIDER)
                    .append(thing.getLabel()).append(TABLE_DIVIDER)
                    .append(thing.getDescription()).append(TABLE_DIVIDER).append("\n");
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
        StringBuilder builder = new StringBuilder(getTableHeader(Arrays.asList(CHANNEL_GROUP_TYPE_HEADER)));
        for (ChannelGroupType channel : channels) {
            builder.append(TABLE_DIVIDER).append(channel.getId()).append(TABLE_DIVIDER)
                    .append(channel.getLabel()).append(TABLE_DIVIDER)
                    .append(channelsToString(channel.getChannels())).append(TABLE_DIVIDER)
                    .append(channel.getDescription()).append(TABLE_DIVIDER).append("\n");
        }
        return builder.toString();
    }

}
