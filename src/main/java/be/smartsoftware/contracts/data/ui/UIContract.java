package be.smartsoftware.contracts.data.ui;

import be.smartsoftware.contracts.data.ui.validator.ValidCountry;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Document(collection = "contracts")
public class UIContract {
    @Id
    @ReadOnlyProperty
    private String id;
    @NotNull
    @Size(min=10, max=300)
    private String name;
    @Version
    private Long version;
    @CreatedDate
    private Date creationTime;
    @LastModifiedDate
    private Date modificationTime;
    @NotNull
    private Boolean active = false;
    @NotNull
    private String currency;
    @NotNull
    @ValidCountry
    private List<UICountry> countries;
    @NotNull
    private List<UITarget> targets;
}
