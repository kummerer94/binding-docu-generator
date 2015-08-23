package org.openhab.models;

/**
 * Created by Alexander on 22.08.2015.
 */
public interface Model<RealImpl> {
    void setModel(RealImpl impl);

    RealImpl getType();
}
