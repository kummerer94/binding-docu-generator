package org.openhab.models;

import org.openhab.schemas.config_description.v1_0.Parameter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexander on 21.08.2015.
 */
public class ConfigDescription {
    protected org.openhab.schemas.config_description.v1_0.ConfigDescription config;

    public ConfigDescription(org.openhab.schemas.config_description.v1_0.ConfigDescription config) {
        this.config = config;

    }

    public String uri() {
        return config.getUri();
    }

    public Map<String, org.openhab.models.Parameter> parameter() {
        Map<String, org.openhab.models.Parameter> parameter = new HashMap<String, org.openhab.models.Parameter>();
        for (Parameter param : config.getParameter()) {
            parameter.put(param.getName(), new org.openhab.models.Parameter(param));
        }
        return parameter;
    }
}
