package gr.cti.ru1.synfield.client.model.measurements;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;


/**
 * Models a Synfield API Measurements Response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SynfieldMeasurementsResponse {

    private List<SynfieldMeasurement> measurements;

    public List<SynfieldMeasurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<SynfieldMeasurement> measurements) {
        this.measurements = measurements;
    }

    @Override
    public String toString() {
        return "SynfieldMeasurementsResponse{" +
                "measurements=" + measurements +
                '}';
    }
}
