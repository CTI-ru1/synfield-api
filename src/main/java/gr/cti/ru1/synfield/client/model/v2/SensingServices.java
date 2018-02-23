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
public class SensingServices {
    private long id;
    @JsonProperty("service_type")
    private ServiceType serviceType;
    
    private Sensor sensor;
    private String name;
    @JsonProperty("name_en")
    private String nameEn;
    @JsonProperty("name_el")
    private String nameEl;
    @JsonProperty("last_changed")
    private String lastChanged;
}
