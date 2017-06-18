package be.smartsoftware.mongodbtest.mapper;

import be.smartsoftware.mongodbtest.linking.LinkingCountry;
import be.smartsoftware.mongodbtest.ui.UICountry;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {
    public LinkingCountry map(UICountry country) {
        return LinkingCountry.builder()
                .code(country.getCode())
                .name(country.getName())
                .currency(country.getCurrency())
                .build();
    }
}
