package gr.cti.ru1.synfield.client.model.v1.sensors;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * Models a Synfield API Sensors Response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SynfieldSensorsResponse {

    private List<SynfieldSensor> sensors;

}
