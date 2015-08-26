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

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.openhab.data.*;
import org.openhab.schemas.config_description.v1_0.ConfigDescription;
import org.openhab.schemas.config_description.v1_0.ConfigDescriptions;
import org.openhab.schemas.thing_description.v1_0.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;

/**
 * Goal which touches a timestamp file.
 * <p/>
 * NOTE: CARE FOR THE NAMESPACE IN {@link ThingDescriptions} and {@link ConfigDescriptions}.
 *
 * @goal generate-docu
 * @phase process-sources
 */
public class MyMojo extends AbstractMojo {

    private static final String XMLSCHEMA = "http://eclipse.org/smarthome/schemas/binding/v1.0.0";
    private static final String THINGXSD = "http://eclipse.org/smarthome/schemas/thing-description-1.0.0.xsd";
    private static final String CHANNEL_GROUP_TYPE = "channel-group-type";

    private ChannelList channels = new ChannelList();
    private ThingList things = new ThingList();
    private ChannelGroupList channelGroups = new ChannelGroupList();
    private BridgeList bridges = new BridgeList();
    private ConfigurationList configList = new ConfigurationList();

    public void execute() throws MojoExecutionException {
        // Configure loggers
        BasicConfigurator.configure();

        // EXAMPLE: ESH-INF
//        String eshDir = "src/test/resources/ESH-INF/";
//        parseThingDescripions(eshDir + "thing/channels.xml");
//        parseThingDescripions(eshDir + "thing/moon.xml");
//        parseThingDescripions(eshDir + "thing/sun.xml");
//        parseThingDescripions(eshDir + "thing/bridge.xml");
//        parseConfigDescriptions(eshDir + "config/config.xml");

        // EXAMPLE: ESH-INF-BOSCH
        String eshDir = "src/test/resources/ESH-INF-BOSCH/";
        parseThingDescripions(eshDir + "thing/thing-types.xml");


        try {
            // Compile mustache template
            MustacheFactory mf = new DefaultMustacheFactory();
            Mustache mustache = mf.compile("src/main/resources/templates/main.mustache");
            HashMap<String, Object> scope = new HashMap<String, Object>();
            scope.put("bridgeList", bridges);
            scope.put("thingList", things);
            scope.put("channelList", channels);
            scope.put("channelGroupList", channelGroups);
            scope.put("configList", configList);
            mustache.execute(new FileWriter("generated-docu-mustache.md"), scope).flush();
        } catch (Exception e) {
            getLog().error(e);
        }
    }

    /**
     * Parses the xml with the available channels.
     *
     * @param file
     */
    private void parseThingDescripions(String file) {
        try {
            JAXBContext jc = JAXBContext.newInstance(ThingDescriptions.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            ThingDescriptions thingDesc = (ThingDescriptions) unmarshaller.unmarshal(new File(file));

            // Go through all the available types
            List<Object> objs = thingDesc.getThingTypeOrBridgeTypeOrChannelType();
            for (Object obj : objs) {
                if (obj instanceof ChannelType) {
                    channels.put((ChannelType) obj);
                } else if (obj instanceof BridgeType) {
                    bridges.put((BridgeType) obj);
                } else if (obj instanceof ChannelGroupType) {
                    channelGroups.put((ChannelGroupType) obj);
                } else if (obj instanceof ThingType) {
                    things.put((ThingType) obj);
                } else {
                    getLog().info("Unsupported class. " + obj.getClass().toString());
                }
            }
        } catch (Exception e) {
            getLog().error(e);
        }
    }

    /**
     * Parses the xml with the available configuration.
     *
     * @param file
     */
    private void parseConfigDescriptions(String file) {
        try {
            JAXBContext jc = JAXBContext.newInstance(ConfigDescriptions.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            ConfigDescriptions configDesc = (ConfigDescriptions) unmarshaller.unmarshal(new File(file));
            for (ConfigDescription c : configDesc.getConfigDescription()) {
                configList.put(c);
            }
        } catch (Exception e) {
            getLog().error(e);
        }
    }

    /**
     * Writes the readme file.
     */
    private void writeReadme() {
//        StringBuilder builder = new StringBuilder(MarkdownProvider.getHeader())
//                .append(MarkdownProvider.handleBridgeTypes(bridgeTypes))
//                .append("\n\n").append(MarkdownProvider.handleBridgeConfig(bridgeTypes))
//                .append("\n\n").append(MarkdownProvider.handleChannelTypes(channelTypes))
//                .append("\n\n").append(MarkdownProvider.handleThingTypes(thingTypes))
//                .append("\n\n").append(MarkdownProvider.handleThingConfig(thingTypes))
//                .append("\n\n").append(MarkdownProvider.handleChannelGroupTypes(channelGroupTypes))
//                .append("\n\n").append(MarkdownProvider.handleConfigDescriptions(config));
//        try {
//            FileUtils.writeStringToFile(new File("generated-docu.md"), builder.toString(), "UTF-8");
//        } catch (IOException e) {
//            getLog().error(e);
//        }
    }


}
