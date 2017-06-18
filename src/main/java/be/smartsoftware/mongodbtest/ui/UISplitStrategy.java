package be.smartsoftware.mongodbtest.ui;

import be.smartsoftware.mongodbtest.linking.LinkingTarget;
import be.smartsoftware.mongodbtest.mapper.CountryMapper;
import be.smartsoftware.mongodbtest.mapper.SplitByCountryStrategy;
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
    Collection<LinkingTarget> execute(UITarget target, UIContract contract, Collection<UICountry> countries, CountryMapper countryMapper);
}
