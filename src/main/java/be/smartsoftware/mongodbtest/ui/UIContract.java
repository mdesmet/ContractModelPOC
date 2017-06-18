package be.smartsoftware.mongodbtest.ui;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Builder
public class UIContract {
    @Id
    private String id;

    private String name;

    @Default
    private Collection<UITarget> targets = new ArrayList<>();

}
