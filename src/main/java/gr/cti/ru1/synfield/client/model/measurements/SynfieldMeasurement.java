package gr.cti.ru1.synfield.client.model.measurements;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * Models a Synfield API Measurement.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SynfieldMeasurement {

    private long id;
    private String service;
    private String timestamp;
    private String unit;
    private String value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public double getDoubleValue() {
        if (unit.equals("Beaufort")) {

            switch (value) {
                case "0.0":
                    return 0.0;
                case "1.0":
                    return (0.3 + 1.5) / 2;
                case "2.0":
                    return (1.5 + 3.3) / 2;
                case "3.0":
                    return (3.3 + 5.5) / 2;
                case "4.0":
                    return (5.5 + 8) / 2;
                case "5.0":
                    return (8 + 10.8) / 2;
                case "6.0":
                    return (10.8 + 13.9) / 2;
                case "7.0":
                    return (13.9 + 17.2) / 2;
                case "8.0":
                    return (17.2 + 20.7) / 2;
                case "9.0":
                    return (20.7 + 24.5) / 2;
                case "10.0":
                    return (24.5 + 28.4) / 2;
                case "11.0":
                    return (28.4 + 32.6) / 2;
                default:
                    return 32.6;
            }
        } else if (service.equals("Wind direction")) {
            switch (value) {
                case "North":
                    return 0;
                case "Northeast":
                    return 45;
                case "East":
                    return 90;
                case "Southeast":
                    return 135;
                case "South":
                    return 180;
                case "Southwest":
                    return 225;
                case "West":
                    return 270;
                case "Northwest":
                    return 315;
            }
        }

        return Double.parseDouble(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", service='" + service + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", unit='" + unit + '\'' +
                ", value='" + value + '\'' +
                ", doubleValue=" + getDoubleValue() +
                '}';
    }
}
