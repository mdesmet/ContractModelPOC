package be.smartsoftware.mongodbtest.ui;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class UIMultiCountryGrouping implements UICountryGrouping {
    private Collection<UICountry> countries;
}
