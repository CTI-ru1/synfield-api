package gr.cti.ru1.synfield.client.model.sensors;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;


/**
 * Models a Synfield API Sensors Response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SynfieldSensorsResponse {

    private List<SynfieldSensor> sensors;

    public List<SynfieldSensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<SynfieldSensor> sensors) {
        this.sensors = sensors;
    }

    @Override
    public String toString() {
        return "Response{" +
                "sensors=" + sensors +
                '}';
    }
}
