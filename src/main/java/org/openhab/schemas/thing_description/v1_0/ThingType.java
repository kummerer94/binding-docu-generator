/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.18 at 07:48:00 PM CEST 
//


package org.openhab.schemas.thing_description.v1_0;

import org.openhab.schemas.config_description.v1_0.ConfigDescription;
import org.openhab.schemas.config_description.v1_0.ConfigDescriptionRef;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for thingType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="thingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="supported-bridge-type-refs" type="{http://eclipse.org/smarthome/schemas/thing-description/v1.0.0}supportedBridgeTypeRefs" minOccurs="0"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="channels" type="{http://eclipse.org/smarthome/schemas/thing-description/v1.0.0}channels"/>
 *           &lt;element name="channel-groups" type="{http://eclipse.org/smarthome/schemas/thing-description/v1.0.0}channelGroups"/>
 *         &lt;/choice>
 *         &lt;element name="properties" type="{http://eclipse.org/smarthome/schemas/thing-description/v1.0.0}properties" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="config-description" type="{http://eclipse.org/smarthome/schemas/config-description/v1.0.0}configDescription"/>
 *           &lt;element name="config-description-ref" type="{http://eclipse.org/smarthome/schemas/config-description/v1.0.0}configDescriptionRef"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://eclipse.org/smarthome/schemas/config-description/v1.0.0}idRestrictionPattern" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "thingType", propOrder = {
        "supportedBridgeTypeRefs",
        "label",
        "description",
        "channels",
        "channelGroups",
        "properties",
        "configDescription",
        "configDescriptionRef"
})
@XmlSeeAlso({
        BridgeType.class
})
public class ThingType {

    @XmlElement(name = "supported-bridge-type-refs")
    protected SupportedBridgeTypeRefs supportedBridgeTypeRefs;
    @XmlElement(required = true)
    protected String label;
    protected String description;
    protected Channels channels;
    @XmlElement(name = "channel-groups")
    protected ChannelGroups channelGroups;
    protected Properties properties;
    @XmlElement(name = "config-description")
    protected ConfigDescription configDescription;
    @XmlElement(name = "config-description-ref")
    protected ConfigDescriptionRef configDescriptionRef;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * Gets the value of the supportedBridgeTypeRefs property.
     *
     * @return possible object is
     * {@link SupportedBridgeTypeRefs }
     */
    public SupportedBridgeTypeRefs getSupportedBridgeTypeRefs() {
        return supportedBridgeTypeRefs;
    }

    /**
     * Sets the value of the supportedBridgeTypeRefs property.
     *
     * @param value allowed object is
     *              {@link SupportedBridgeTypeRefs }
     */
    public void setSupportedBridgeTypeRefs(SupportedBridgeTypeRefs value) {
        this.supportedBridgeTypeRefs = value;
    }

    /**
     * Gets the value of the label property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the channels property.
     *
     * @return possible object is
     * {@link Channels }
     */
    public Channels getChannels() {
        return channels;
    }

    /**
     * Sets the value of the channels property.
     *
     * @param value allowed object is
     *              {@link Channels }
     */
    public void setChannels(Channels value) {
        this.channels = value;
    }

    /**
     * Gets the value of the channelGroups property.
     *
     * @return possible object is
     * {@link ChannelGroups }
     */
    public ChannelGroups getChannelGroups() {
        return channelGroups;
    }

    /**
     * Sets the value of the channelGroups property.
     *
     * @param value allowed object is
     *              {@link ChannelGroups }
     */
    public void setChannelGroups(ChannelGroups value) {
        this.channelGroups = value;
    }

    /**
     * Gets the value of the properties property.
     *
     * @return possible object is
     * {@link Properties }
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     *
     * @param value allowed object is
     *              {@link Properties }
     */
    public void setProperties(Properties value) {
        this.properties = value;
    }

    /**
     * Gets the value of the configDescription property.
     *
     * @return possible object is
     * {@link ConfigDescription }
     */
    public ConfigDescription getConfigDescription() {
        return configDescription;
    }

    /**
     * Sets the value of the configDescription property.
     *
     * @param value allowed object is
     *              {@link ConfigDescription }
     */
    public void setConfigDescription(ConfigDescription value) {
        this.configDescription = value;
    }

    /**
     * Gets the value of the configDescriptionRef property.
     *
     * @return possible object is
     * {@link ConfigDescriptionRef }
     */
    public ConfigDescriptionRef getConfigDescriptionRef() {
        return configDescriptionRef;
    }

    /**
     * Sets the value of the configDescriptionRef property.
     *
     * @param value allowed object is
     *              {@link ConfigDescriptionRef }
     */
    public void setConfigDescriptionRef(ConfigDescriptionRef value) {
        this.configDescriptionRef = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

}
