package be.smartsoftware.mongodbtest.mapper;

import be.smartsoftware.mongodbtest.ui.UISplitStrategy;
import be.smartsoftware.mongodbtest.linking.LinkingTarget;
import be.smartsoftware.mongodbtest.ui.UITarget;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TargetMapper {
    public Collection<LinkingTarget> map(UITarget target) {
        UISplitStrategy UISplitStrategy = target.getSplitStrategy().orElse(new NullSplitStrategy());
        return UISplitStrategy.execute(target);
    }
}
