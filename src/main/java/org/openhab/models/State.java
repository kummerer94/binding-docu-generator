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

public class State implements Model<org.openhab.schemas.thing_description.v1_0.State> {
    /**
     * Instance from the XML parser.
     */
    protected org.openhab.schemas.thing_description.v1_0.State state;

    /**
     * Default constructor.
     */
    public State() {
    }

    /**
     * Constructor.
     *
     * @param state The original instance from the XML parser.
     */
    public State(org.openhab.schemas.thing_description.v1_0.State state) {
        setModel(state);
    }

    /**
     * @return Instance from the XML parser.
     */
    public org.openhab.schemas.thing_description.v1_0.State getRealImpl() {
        return state;
    }

    /**
     * Set the model.
     *
     * @param state Instance from the XML parser.
     */
    public void setModel(org.openhab.schemas.thing_description.v1_0.State state) {
        this.state = state;
    }

    /**
     * @return Whether the state is readonly.
     */
    public Boolean readOnly() {
        return state.isReadOnly();
    }

    /**
     * @return The minimal value of the state.
     */
    public BigDecimal min() {
        return state.getMin();
    }

    /**
     * @return The maximal value of the state.
     */
    public BigDecimal max() {
        return state.getMax();
    }

    /**
     * @return The step between the values of the state.
     */
    public BigDecimal step() {
        return state.getStep();
    }

    /**
     * @return The pattern for the state.
     */
    public String pattern() {
        return state.getPattern();
    }

    /**
     * @return A list of options.
     */
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
