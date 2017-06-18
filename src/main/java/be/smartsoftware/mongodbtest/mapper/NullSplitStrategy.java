package be.smartsoftware.mongodbtest.mapper;


import be.smartsoftware.mongodbtest.linking.LinkingTarget;
import be.smartsoftware.mongodbtest.ui.UISplitStrategy;
import be.smartsoftware.mongodbtest.ui.UITarget;

import java.util.Arrays;
import java.util.Collection;


public class NullSplitStrategy implements UISplitStrategy {
    @Override
    public Collection<LinkingTarget> execute(UITarget target) {
        return Arrays.asList(LinkingTarget.builder().name((target.getName())).build());
    }
}
