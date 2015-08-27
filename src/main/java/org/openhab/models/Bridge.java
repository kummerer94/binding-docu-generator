/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.openhab.models;

import org.openhab.schemas.thing_description.v1_0.BridgeType;
import org.openhab.schemas.thing_description.v1_0.BridgeTypeRef;
import org.openhab.schemas.thing_description.v1_0.ThingType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 21.08.2015.
 * <p/>
 * Wrapper class to not fully depend on the existing models.
 */
public class Bridge extends Thing {
    /**
     * The object we get from the XML parser.
     */
    protected BridgeType bridge;

    /**
     * Default constructor.
     */
    public Bridge() {
    }

    /**
     * @param bridge The object from the XML parser.
     */
    public Bridge(BridgeType bridge) {
        super((ThingType) bridge);
        this.bridge = bridge;
    }

    /**
     * @return Returns the {@link BridgeType} instance.
     */
    @Override
    public BridgeType getRealImpl() {
        return bridge;
    }

    /**
     * @return Returns the supported bridge type refs, a list of URIs.
     */
    public List<String> supportedBridgeTypeRefs() {
        List<String> refs = new ArrayList<String>();
        if (bridge.getSupportedBridgeTypeRefs() != null) {
            for (BridgeTypeRef ref : bridge.getSupportedBridgeTypeRefs().getBridgeTypeRef()) {
                refs.add(ref.getId());
            }
        }
        return refs;
    }

}
