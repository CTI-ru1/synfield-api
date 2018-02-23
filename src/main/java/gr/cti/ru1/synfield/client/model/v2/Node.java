package gr.cti.ru1.synfield.client.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Node {
    private long id;
    @JsonProperty("node_module")
    private String nodeModule;
    @JsonProperty("node_type")
    private String nodeType;
    private String name;
    @JsonProperty("serial_number")
    private String serialNumber;
    @JsonProperty("firmware_version")
    private String firmwareVersion;
    private double longitude;
    private double latitude;
    private double altitude;
    @JsonProperty("last_data_entry")
    private String lastDataEntry;
    //    private String parentNode;
}
