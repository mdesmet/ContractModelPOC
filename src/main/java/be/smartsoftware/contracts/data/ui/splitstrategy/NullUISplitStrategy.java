package be.smartsoftware.contracts.data.ui.splitstrategy;


import be.smartsoftware.contracts.data.ui.UICountry;
import be.smartsoftware.contracts.data.ui.UIMultiCountryGrouping;
import be.smartsoftware.contracts.data.ui.UISplitStrategy;

import java.util.Arrays;
import java.util.Collection;

public class NullUISplitStrategy implements UISplitStrategy {
    @Override
    public Collection<UIMultiCountryGrouping> execute(Collection<UICountry> countries) {
        return Arrays.asList(UIMultiCountryGrouping.builder().countries(countries).build());
    }
}
