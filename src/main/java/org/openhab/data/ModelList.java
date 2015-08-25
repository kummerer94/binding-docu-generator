package org.openhab.data;

import org.openhab.models.Model;

import java.util.ArrayList;

/**
 * Created by Alexander on 22.08.2015.
 */
public abstract class ModelList extends ArrayList<ListElement> {
    public void put(Object impl) {
        Model model = getNewModel();
        model.setModel(impl);
        getLast().setLast(false);
        this.add(new ListElement(model));
        // Reset last
        getLast().setLast(true);
    }

    public ListElement getLast() {
        if (!this.isEmpty()) {
            return this.get(this.size() - 1);
        } else {
            return new ListElement(null);
        }
    }

    public boolean empty() {
        return this.isEmpty();
    }

    public abstract Model getNewModel();

}
