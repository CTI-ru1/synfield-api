package gr.cti.ru1.synfield.client.model.sensors;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * Models a Synfield API Sensor Response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SynfieldSensor {
    private String enabled;
    private long id;
    private String name;
    private String service;

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "enabled='" + enabled + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", service='" + service + '\'' +
                '}';
    }
}
