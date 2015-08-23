package org.openhab.data;

import org.openhab.models.Thing;

/**
 * Created by Alexander on 22.08.2015.
 */
public class ThingList extends ModelList {
    public Thing getNewModel() {
        return new Thing();
    }
}
