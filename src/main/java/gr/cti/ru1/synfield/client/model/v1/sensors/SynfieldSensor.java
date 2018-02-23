package gr.cti.ru1.synfield.client.model.v1.sensors;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Models a Synfield API Sensor Response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SynfieldSensor {
    private String enabled;
    private long id;
    private String name;
    private String service;
}
