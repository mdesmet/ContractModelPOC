package be.smartsoftware.mongodbtest.mapper;

import be.smartsoftware.mongodbtest.ui.UIContract;
import be.smartsoftware.mongodbtest.ui.UICountry;
import be.smartsoftware.mongodbtest.ui.UISplitStrategy;
import be.smartsoftware.mongodbtest.linking.LinkingTarget;
import be.smartsoftware.mongodbtest.ui.UITarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TargetMapper {
    private CountryResolver countryResolver;

    @Autowired
    public TargetMapper(CountryResolver countryResolver) {
        this.countryResolver = countryResolver;
    }

    public Collection<LinkingTarget> map(UITarget target, UIContract contract) {
        UISplitStrategy UISplitStrategy = target.getSplitStrategy().orElse(new NullSplitStrategy());
        Collection<UICountry> countries = countryResolver.resolveCountries(contract, target);
        return UISplitStrategy.execute(target, contract, countries);
    }
}
