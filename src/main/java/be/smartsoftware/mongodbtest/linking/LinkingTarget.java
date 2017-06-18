package be.smartsoftware.mongodbtest.linking;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LinkingTarget {
    private String country;
    private String name;
    private String currency;
}
