package gr.cti.ru1.synfield.client.model.sensors;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * Models a Synfield API Sensors Page.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SynfieldSensorsPage {

    private SynfieldSensorsResponse response;

    public SynfieldSensorsResponse getResponse() {
        return response;
    }

    public void setResponse(SynfieldSensorsResponse response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "SynfieldSensorsResponse{" +
                "response=" + response +
                '}';
    }
}
