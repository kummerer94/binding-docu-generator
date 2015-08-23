package org.openhab.data;

import org.openhab.models.Model;

/**
 * Created by Alexander on 23.08.2015.
 */
public class ListElement {
    protected Model element;
    protected boolean isLast;

    public ListElement(Model model) {
        setModel(model);
    }

    public void setLast(boolean isLast) {
        this.isLast = isLast;
    }

    public boolean isNotLast() {
        return !isLast;
    }

    public void setModel(Model model) {
        this.element = model;
    }

    public Model model() {
        return element;
    }
}
