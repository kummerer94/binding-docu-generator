package org.openhab.data;

import org.openhab.models.Parameter;

/**
 * Created by Alexander on 26.08.2015.
 */
public class ParameterList extends ModelList {
    /**
     * @return Returns a new {@link Parameter} object.
     */
    public Parameter getNewModel() {
        return new Parameter();
    }
}
