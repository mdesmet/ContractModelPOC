package be.smartsoftware.contracts.data.reference;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "countries")
public class ReferenceCountry {
    private String code;
    private String name;
    private String currency;
}
