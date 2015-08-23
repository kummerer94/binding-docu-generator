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

    protected BridgeType bridge;

    public Bridge() {
    }

    public Bridge(BridgeType bridge) {
        super((ThingType) bridge);
        this.bridge = bridge;
    }

    @Override
    public BridgeType getType() {
        return bridge;
    }

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
