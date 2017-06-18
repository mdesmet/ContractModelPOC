package be.smartsoftware.mongodbtest.ui;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Builder
public class UIContract {
    @Id
    private String id;
    private String name;
    private String currency;
    @Default
    private Collection<UICountry> countries = new ArrayList<>();
    @Default
    private Collection<UITarget> targets = new ArrayList<>();

}
