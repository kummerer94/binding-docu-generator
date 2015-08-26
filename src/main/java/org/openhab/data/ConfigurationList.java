package org.openhab.data;

import org.openhab.models.ConfigDescription;

/**
 * Created by Alexander on 22.08.2015.
 */
public class ConfigurationList extends ModelList {
    /**
     * @return Returns a new {@link ConfigDescription} object.
     */
    public ConfigDescription getNewModel() {
        return new ConfigDescription();
    }
}
