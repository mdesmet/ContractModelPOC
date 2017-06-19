package be.smartsoftware.mongodbtest.ui.splitstrategy;


import be.smartsoftware.mongodbtest.ui.UICountry;
import be.smartsoftware.mongodbtest.ui.UIMultiCountryGrouping;
import be.smartsoftware.mongodbtest.ui.UISplitStrategy;

import java.util.Arrays;
import java.util.Collection;

public class NullUISplitStrategy implements UISplitStrategy {
    @Override
    public Collection<UIMultiCountryGrouping> execute(Collection<UICountry> countries) {
        return Arrays.asList(UIMultiCountryGrouping.builder().countries(countries).build());
    }
}
