package org.openhab.models;

/**
 * Created by Alexander on 22.08.2015.
 *
 * The models implementing this interface act as an additional layer between the data we
 * parse from the XML files and the concrete use of these models in the template system.
 */
public interface Model<RealImpl> {
    /**
     * @param impl Setter for the model.
     */
    void setModel(RealImpl impl);

    /**
     * @return Returns the {@link RealImpl} object.
     */
    RealImpl getRealImpl();
}
