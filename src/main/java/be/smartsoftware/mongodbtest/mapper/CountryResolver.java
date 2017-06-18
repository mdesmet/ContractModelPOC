package be.smartsoftware.mongodbtest.mapper;

import be.smartsoftware.mongodbtest.ui.UIContract;
import be.smartsoftware.mongodbtest.ui.UICountry;
import be.smartsoftware.mongodbtest.ui.UITarget;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Collections;

@Component
public class CountryResolver {

    public Collection<UICountry> resolveCountries(UIContract contract, UITarget target) {
        Collection<UICountry> contractCountries = contract.getCountries();
        Assert.notEmpty(contractCountries, "Global contracts not yet supported...");
        Collection<UICountry> targetCountries = target.getCountries();
        if(targetCountries.isEmpty()) {
            return Collections.unmodifiableCollection(contractCountries);
        }
        return Collections.unmodifiableCollection(targetCountries);

    }
}
