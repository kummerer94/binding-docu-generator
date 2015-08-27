/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.openhab.models;

import org.openhab.data.OptionList;

import java.math.BigDecimal;

/**
 * Created by Alexander on 25.08.2015.
 */
public class State {
    protected org.openhab.schemas.thing_description.v1_0.State state;

    public State() {

    }

    public State(org.openhab.schemas.thing_description.v1_0.State state) {
        setModel(state);
    }

    public org.openhab.schemas.thing_description.v1_0.State getType() {
        return state;
    }

    public void setModel(org.openhab.schemas.thing_description.v1_0.State state) {
        this.state = state;
    }

    public Boolean readOnly() {
        return state.isReadOnly();
    }

    public BigDecimal min() {
        return state.getMin();
    }

    public BigDecimal max() {
        return state.getMax();
    }

    public BigDecimal step() {
        return state.getStep();
    }

    public String pattern() {
        return state.getPattern();
    }

    public OptionList options() {
        OptionList optionList = new OptionList();
        if (state.getOptions() != null) {
            for (org.openhab.schemas.thing_description.v1_0.Option option : state.getOptions().getOption()) {
                optionList.put(option);
            }
        }
        return optionList;
    }

}
