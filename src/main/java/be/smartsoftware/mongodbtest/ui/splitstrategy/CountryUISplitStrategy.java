package be.smartsoftware.mongodbtest.ui.splitstrategy;

import be.smartsoftware.mongodbtest.ui.UICountry;
import be.smartsoftware.mongodbtest.ui.UISingleCountryGrouping;
import be.smartsoftware.mongodbtest.ui.UISplitStrategy;
import lombok.Builder;
import lombok.Value;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Builder
@Value
public class CountryUISplitStrategy implements UISplitStrategy {
    private Boolean useCountryCurrency;

    @Override
    public Collection<UISingleCountryGrouping> execute(Collection<UICountry> countries) {
        return countries
                .stream()
                .map(country -> buildUICountryGrouping(country))
                .collect(toList());
    }

    private UISingleCountryGrouping buildUICountryGrouping(UICountry country) {
        return UISingleCountryGrouping.builder()
                .country(country)
                .useCountryCurrency(useCountryCurrency)
                .build();
    }
}
