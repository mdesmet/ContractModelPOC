package be.smartsoftware.mongodbtest.ui;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UICountry {
    public String name;
    public String code;
    public String currency;
}
