package org.openhab.models;

import org.openhab.data.ParameterList;
import org.openhab.schemas.config_description.v1_0.Parameter;

/**
 * Created by Alexander on 21.08.2015.
 */
public class ConfigDescription implements Model<org.openhab.schemas.config_description.v1_0.ConfigDescription> {
    protected org.openhab.schemas.config_description.v1_0.ConfigDescription config;

    public ConfigDescription() {

    }

    public ConfigDescription(org.openhab.schemas.config_description.v1_0.ConfigDescription config) {
        setModel(config);
    }

    public org.openhab.schemas.config_description.v1_0.ConfigDescription getRealImpl() {
        return config;
    }

    public void setModel(org.openhab.schemas.config_description.v1_0.ConfigDescription config) {
        this.config = config;
    }

    public String uri() {
        return config.getUri();
    }

    public ParameterList parameter() {
        ParameterList parameterList = new ParameterList();
        for (Parameter param : config.getParameter()) {
            parameterList.put(param);
        }
        return parameterList;
    }
}
