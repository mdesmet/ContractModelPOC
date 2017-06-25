package be.smartsoftware.contracts.data.ui;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class UICountry {
    @NotNull
    private String code;
    @NotNull
    private String name;
    @NotNull
    private String currency;
}
