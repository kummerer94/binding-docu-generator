package org.openhab.data;

import org.openhab.models.Bridge;

/**
 * Created by Alexander on 22.08.2015.
 */
public class BridgeList extends ModelList {
    public Bridge getNewModel() {
        return new Bridge();
    }
}
