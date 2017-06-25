package be.smartsoftware.contracts.data.mapper;

import be.smartsoftware.contracts.data.linking.LinkingCountry;
import be.smartsoftware.contracts.data.ui.UICountry;
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
