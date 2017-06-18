package be.smartsoftware.mongodbtest.linking;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Builder
public class LinkingTarget {
    private String name;
    private String currency;
    @Default
    private Collection<String> countries = new ArrayList<>();
}
