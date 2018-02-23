package gr.cti.ru1.synfield.client.model.v1.measurements;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * Models a Synfield API Measurements Response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SynfieldMeasurementsResponse {

    private List<SynfieldMeasurement> measurements;

}
