package be.smartsoftware.mongodbtest.mapper;


import be.smartsoftware.mongodbtest.linking.LinkingTarget;
import be.smartsoftware.mongodbtest.ui.UIContract;
import be.smartsoftware.mongodbtest.ui.UICountry;
import be.smartsoftware.mongodbtest.ui.UISplitStrategy;
import be.smartsoftware.mongodbtest.ui.UITarget;

import java.util.Arrays;
import java.util.Collection;

import static java.util.stream.Collectors.toList;


public class NullSplitStrategy implements UISplitStrategy {
    @Override
    public Collection<LinkingTarget> execute(UITarget target, UIContract contract, Collection<UICountry> countries) {
        return Arrays.asList(LinkingTarget
                .builder()
                .name((target.getName()))
                .currency(contract.getCurrency())
                .countries(
                        countries.stream().map(UICountry::getName)
                        .collect(toList())
                )
                .build());
    }
}
