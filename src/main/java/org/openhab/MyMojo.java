/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.openhab;

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

    //    private static final String XMLSCHEMA = "http://eclipse.org/smarthome/schemas/binding/v1.0.0";
//    private static final String THINGXSD = "http://eclipse.org/smarthome/schemas/thing-description-1.0.0.xsd";
    private static final String THING_SUBDIR = "thing/";
    private static final String BINDING_SUBDIR = "binding/";
    private static final String CONFIG_SUBDIR = "config/";

    private ChannelList channels = new ChannelList();
    private ThingList things = new ThingList();
    private ChannelGroupList channelGroups = new ChannelGroupList();
    private BridgeList bridges = new BridgeList();
    private ConfigurationList configList = new ConfigurationList();

    /**
     * @parameter name="esh-inf-dir" alias="eshInfDir" default-value="ESH-INF/"
     */
    private String eshDir;


    public void execute() throws MojoExecutionException {
        // Configure loggers
        BasicConfigurator.configure();

        // EXAMPLE: ESH-INF
//        eshDir = "src/test/resources/ESH-INF/";
//        parseThingDescriptions(eshDir + "thing/channels.xml");
//        parseThingDescriptions(eshDir + "thing/moon.xml");
//        parseThingDescriptions(eshDir + "thing/sun.xml");
//        parseThingDescriptions(eshDir + "thing/bridge.xml");
//        parseConfigDescriptions(eshDir + "config/config.xml");


        // EXAMPLE: ESH-INF-BOSCH
        eshDir = "src/test/resources/ESH-INF-BOSCH/";
        scanDir();

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
     * Scans the given eshDir for xml files.
     */
    private void scanDir() {
        // Scan the things directory
        File things = new File(eshDir + THING_SUBDIR);
        if (things.exists() && things.isDirectory()) {
            for (File file : things.listFiles()) {
                if (file.getName().endsWith(".xml")) {
                    getLog().info("Found thing xml: " + file.getName());
                    parseThingDescriptions(file.getAbsolutePath());
                }
            }
        }

        // Scan the config directory.
        File configs = new File(eshDir + CONFIG_SUBDIR);
        if (configs.exists() && configs.isDirectory()) {
            for (File file : things.listFiles()) {
                if (file.getName().endsWith(".xml")) {
                    getLog().info("Found config xml: " + file.getName());
                    parseConfigDescriptions(file.getAbsolutePath());
                }
            }
        }
    }

    /**
     * Parses the xml with the available channels.
     *
     * @param file
     */
    private void parseThingDescriptions(String file) {
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
}
