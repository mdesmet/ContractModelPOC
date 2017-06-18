package be.smartsoftware.mongodbtest.ui;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Data
@Builder
public class UITarget {
    @Default
    private Collection<UICountry> countries = new ArrayList<>();
    private String name;
    @Default
    private Optional<UISplitStrategy> splitStrategy = Optional.empty();
}
