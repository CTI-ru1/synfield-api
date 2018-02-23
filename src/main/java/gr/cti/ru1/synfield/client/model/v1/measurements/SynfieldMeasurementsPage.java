package gr.cti.ru1.synfield.client.model.v1.measurements;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Models a Synfield API Measurements Page.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SynfieldMeasurementsPage {
    
    private SynfieldMeasurementsResponse response;

}
