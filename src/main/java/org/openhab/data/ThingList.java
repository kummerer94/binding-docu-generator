package org.openhab.data;

import org.openhab.models.Thing;

/**
 * Created by Alexander on 22.08.2015.
 */
public class ThingList extends ModelList {
    /**
     * Returns a new {@link Thing} object.
     *
     * @return
     */
    public Thing getNewModel() {
        return new Thing();
    }
}
