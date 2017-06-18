package be.smartsoftware.mongodbtest.mapper;

import be.smartsoftware.mongodbtest.linking.LinkingTarget;
import be.smartsoftware.mongodbtest.ui.UIContract;
import be.smartsoftware.mongodbtest.ui.UICountry;
import be.smartsoftware.mongodbtest.ui.UISplitStrategy;
import be.smartsoftware.mongodbtest.ui.UITarget;
import lombok.Builder;
import lombok.Value;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Builder
@Value
public class SplitByCountryStrategy implements UISplitStrategy {
    private Boolean useCountryCurrency;

    @Override
    public Collection<LinkingTarget> execute(UITarget target, UIContract contract, Collection<UICountry> countries) {
        Assert.notNull(useCountryCurrency, "useCountryCurrency not set for target with name '" + target.getName() + "'");
        return countries
                .stream()
                .map(country ->
                        LinkingTarget.builder()
                                .name((target.getName() + " " + country.getCode()))
                                .currency(useCountryCurrency ? country.getCurrency() : contract.getCurrency())
                                .countries(Arrays.asList(country.getName()))
                                .build())
                .collect(toList());
    }
}
