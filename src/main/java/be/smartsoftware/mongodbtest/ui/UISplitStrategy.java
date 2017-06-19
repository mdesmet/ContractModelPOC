package be.smartsoftware.mongodbtest.ui;

import be.smartsoftware.mongodbtest.ui.splitstrategy.CountryUISplitStrategy;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Collection;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CountryUISplitStrategy.class, name = "SPLIT_BY_POS")}
)
public interface UISplitStrategy {
    Collection<? extends UICountryGrouping> execute(Collection<UICountry> countries);
}
