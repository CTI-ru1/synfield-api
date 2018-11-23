package gr.cti.ru1.synfield.client.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Measurement {
    
    private int sensing_service_id;
    private double value;
    private String ontime;
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Measurement that = (Measurement) o;
        return sensing_service_id == that.sensing_service_id && Double.compare(that.value, value) == 0 && Objects.equals(ontime, that.ontime);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(sensing_service_id, value, ontime);
    }
}
