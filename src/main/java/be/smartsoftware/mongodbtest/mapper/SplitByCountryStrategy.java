package be.smartsoftware.mongodbtest.mapper;

import be.smartsoftware.mongodbtest.linking.LinkingTarget;
import be.smartsoftware.mongodbtest.ui.UISplitStrategy;
import be.smartsoftware.mongodbtest.ui.UITarget;
import lombok.Builder;
import lombok.Value;
import org.springframework.util.Assert;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Builder
@Value
public class SplitByCountryStrategy implements UISplitStrategy {
    private Boolean useCountryCurrency;

    @Override
    public Collection<LinkingTarget> execute(UITarget target) {
        Assert.notEmpty(target.getCountries(), "No countries in target with name '" + target.getName() + "'");
        Assert.notNull(useCountryCurrency, "useCountryCurrency not set for target with name '" + target.getName() + "'");
        return target.getCountries()
                .stream()
                .map(country ->
                        LinkingTarget.builder()
                                .name((target.getName() + " " + country.getCode()))
                                .currency(useCountryCurrency ? country.getCurrency() : null /* TODO: replace with contract currency */)
                                .country(country.getName())
                                .build())
                .collect(toList());
    }
}
