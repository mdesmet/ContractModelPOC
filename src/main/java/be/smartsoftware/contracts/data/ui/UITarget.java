package be.smartsoftware.contracts.data.ui;

import be.smartsoftware.contracts.data.ui.validator.ValidCountry;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@Builder
public class UITarget {
    @NotNull
    @ValidCountry
    private Collection<UICountry> countries;
    @NotNull
    @Size(min=10, max=300)
    private String name;
    private UISplitStrategy splitStrategy;
}
