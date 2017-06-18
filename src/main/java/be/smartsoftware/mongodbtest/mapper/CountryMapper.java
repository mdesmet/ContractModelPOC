package be.smartsoftware.mongodbtest.mapper;

import be.smartsoftware.mongodbtest.linking.LinkingCountry;
import be.smartsoftware.mongodbtest.ui.UICountry;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Component
public class CountryMapper {

    public Collection<LinkingCountry> map(Collection<UICountry> countries) {
        return countries.stream()
                .map(country -> LinkingCountry.builder()
                        .code(country.getCode())
                        .name(country.getName())
                        .currency(country.getCurrency())
                        .build())
                .collect(toList());
    }
}
