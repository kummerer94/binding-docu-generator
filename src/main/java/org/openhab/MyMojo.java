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
import org.openhab.schemas.thing_description.v1_0.ThingDescriptions;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    public void execute() throws MojoExecutionException {
        Path curPath = Paths.get("");
        getLog().info(curPath.toAbsolutePath().toString());

        String eshDir = "src/test/resources/ESH-INF/";
        parseChannelGroupType(eshDir + "thing/channels.xml");
    }

    /**
     * NOTE: CARE FOR THE FUCKING NAMESPACE IN {@link ThingDescriptions} and {@link ConfigDescriptions}.
     *
     * @param channel
     */
    private void parseChannelGroupType(String channel) {
        try {
            JAXBContext jc = JAXBContext.newInstance(ThingDescriptions.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            ThingDescriptions thingDesc = (ThingDescriptions) unmarshaller.unmarshal(new File(channel));

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(thingDesc, System.out);
        } catch (Exception e) {
            getLog().error(e);
        }
    }
}
