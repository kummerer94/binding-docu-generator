package org.openhab.data;

import org.openhab.models.Option;

/**
 * Created by Alexander on 26.08.2015.
 */
public class OptionList extends ModelList {
    public Option getNewModel() {
        return new Option();
    }
}
