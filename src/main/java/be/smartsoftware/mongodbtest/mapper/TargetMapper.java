package be.smartsoftware.mongodbtest.mapper;

import be.smartsoftware.mongodbtest.linking.LinkingTarget;
import be.smartsoftware.mongodbtest.ui.*;
import be.smartsoftware.mongodbtest.ui.splitstrategy.NullUISplitStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Component
public class TargetMapper {
    private UICountryResolver countryResolver;
    private CountryMapper countryMapper;

    @Autowired
    public TargetMapper(UICountryResolver countryResolver, CountryMapper countryMapper) {
        this.countryResolver = countryResolver;
        this.countryMapper = countryMapper;
    }

    public Collection<LinkingTarget> map(UITarget target, UIContract contract) {
        Collection<UICountry> countries = countryResolver.resolveCountries(contract, target);
        Collection<? extends UICountryGrouping> groupings = target.getSplitStrategy().orElse(new NullUISplitStrategy()).execute(countries);

        return groupings
                .stream()
                .map(grouping -> buildLinkingTarget(target, contract, grouping))
                .collect(toList());
    }

    private LinkingTarget buildLinkingTarget(UITarget target, UIContract contract, UICountryGrouping grouping) {
        if (grouping instanceof UIMultiCountryGrouping) {
            return buildLinkingTarget(target, contract, (UIMultiCountryGrouping) grouping);
        }
        if (grouping instanceof UISingleCountryGrouping) {
            return buildLinkingTarget(target, contract, (UISingleCountryGrouping) grouping);
        }
        return null;
    }

    private LinkingTarget buildLinkingTarget(UITarget target, UIContract contract, UISingleCountryGrouping grouping) {
        return LinkingTarget
                .builder()
                .name((target.getName()))
                .currency(grouping.getUseCountryCurrency() ? contract.getCurrency() : grouping.getCountry().getCurrency())
                .countries(Arrays.asList(countryMapper.map(grouping.getCountry())))
                .build();
    }

    private LinkingTarget buildLinkingTarget(UITarget target, UIContract contract, UIMultiCountryGrouping grouping) {
        return LinkingTarget
                .builder()
                .name((target.getName()))
                .currency(contract.getCurrency())
                .countries(grouping.getCountries().stream()
                        .map(countryMapper::map)
                        .collect(toList()))
                .build();
    }
}
