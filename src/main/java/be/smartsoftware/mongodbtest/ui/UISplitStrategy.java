package be.smartsoftware.mongodbtest.ui;

import be.smartsoftware.mongodbtest.mapper.SplitByCountryStrategy;
import be.smartsoftware.mongodbtest.linking.LinkingTarget;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Collection;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SplitByCountryStrategy.class, name = "SPLIT_BY_POS") }
)
public interface UISplitStrategy {
    Collection<LinkingTarget> execute(UITarget target);
}