package org.openhab.models;

/**
 * Created by Alexander on 26.08.2015.
 */
public class Option implements Model<org.openhab.schemas.thing_description.v1_0.Option> {

    private org.openhab.schemas.thing_description.v1_0.Option option;

    public Option() {

    }

    public Option(org.openhab.schemas.thing_description.v1_0.Option option) {
        setModel(option);
    }

    public org.openhab.schemas.thing_description.v1_0.Option getType() {
        return option;
    }

    public void setModel(org.openhab.schemas.thing_description.v1_0.Option option) {
        this.option = option;
    }

    public String value() {
        return option.getValue();
    }
}
