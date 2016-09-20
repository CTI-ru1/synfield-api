package gr.cti.ru1.synfield.client.model.measurements;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * Models a Synfield API Measurements Page.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SynfieldMeasurementsPage {

    private SynfieldMeasurementsResponse response;

    public SynfieldMeasurementsResponse getResponse() {
        return response;
    }

    public void setResponse(SynfieldMeasurementsResponse response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "SynfieldMeasurementsPage{" +
                "response=" + response +
                '}';
    }
}
