package be.smartsoftware.mongodbtest.linking;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Builder
@Data
public class LinkingContract {
    private String name;
    private Collection<LinkingTarget> targets;
}
