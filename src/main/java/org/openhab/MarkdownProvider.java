package org.openhab;

import org.apache.commons.lang3.StringUtils;
import org.openhab.schemas.thing_description.v1_0.ChannelType;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexander on 18.08.2015.
 */
public class MarkdownProvider {

    private final static String[] CHANNEL_TYPE_HEADER = {"Channel Type Id", "Item Type", "Description"};
    public static final String TABLE_DIVIDER = "|";

    private static StringBuilder getTableHeader(List<String> cols) {
        StringBuilder builder = new StringBuilder(TABLE_DIVIDER);
        for (String col : cols) {
            builder.append(col).append(TABLE_DIVIDER);
        }
        builder.append("\n");
        builder.append('|').append(StringUtils.repeat("---" + TABLE_DIVIDER, cols.size())).append("\n");
        return builder;
    }

    public static String handleChannels(List<ChannelType> channels) {
        StringBuilder builder = new StringBuilder();
        builder.append(getTableHeader(Arrays.asList(CHANNEL_TYPE_HEADER)));
        for (ChannelType channel : channels) {
            builder.append(channel.getId()).append(TABLE_DIVIDER)
                    .append(channel.getItemType()).append(TABLE_DIVIDER)
                    .append(channel.getDescription()).append(TABLE_DIVIDER).append("\n");
        }
        return builder.toString();
    }

}
