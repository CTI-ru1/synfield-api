package gr.cti.ru1.synfield.client.model.v1.sensors;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Models a Synfield API Sensors Page.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SynfieldSensorsPage {

    private SynfieldSensorsResponse response;

}
