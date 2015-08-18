package org.openhab;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.openhab.schemas.config_description.v1_0.ConfigDescriptions;
import org.openhab.schemas.thing_description.v1_0.ChannelGroupType;
import org.openhab.schemas.thing_description.v1_0.ChannelType;
import org.openhab.schemas.thing_description.v1_0.ThingDescriptions;
import org.openhab.schemas.thing_description.v1_0.ThingType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Goal which touches a timestamp file.
 *
 * @goal generate-docu
 * @phase process-sources
 */
public class MyMojo extends AbstractMojo {

    private static final String XMLSCHEMA = "http://eclipse.org/smarthome/schemas/binding/v1.0.0";
    private static final String THINGXSD = "http://eclipse.org/smarthome/schemas/thing-description-1.0.0.xsd";
    private static final String CHANNEL_GROUP_TYPE = "channel-group-type";

    private List<ChannelType> channelTypes = new ArrayList<ChannelType>();
    private List<ThingType> thingTypes = new ArrayList<ThingType>();
    private List<ChannelGroupType> channelGroupTypes = new ArrayList<ChannelGroupType>();

    public void execute() throws MojoExecutionException {
        Path curPath = Paths.get("");
        getLog().info(curPath.toAbsolutePath().toString());

        String eshDir = "src/test/resources/ESH-INF/";
        parseChannels(eshDir + "thing/channels.xml");
    }

    /**
     * NOTE: CARE FOR THE NAMESPACE IN {@link ThingDescriptions} and {@link ConfigDescriptions}.
     *
     * @param channel
     */
    private void parseChannels(String channel) {
        try {
            JAXBContext jc = JAXBContext.newInstance(ThingDescriptions.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            ThingDescriptions thingDesc = (ThingDescriptions) unmarshaller.unmarshal(new File(channel));

            // Go through all the available types
            List<Object> objs = thingDesc.getThingTypeOrBridgeTypeOrChannelType();
            for (Object obj : objs) {
                if (obj instanceof ChannelType) {
                    channelTypes.add((ChannelType) obj);
                } else if (obj instanceof ThingType) {
                    thingTypes.add((ThingType) obj);
                } else if (obj instanceof ChannelGroupType) {
                    channelGroupTypes.add((ChannelGroupType) obj);
                }
            }

            getLog().info(MarkdownProvider.handleChannels(channelTypes));
        } catch (Exception e) {
            getLog().error(e);
        }
    }
}
