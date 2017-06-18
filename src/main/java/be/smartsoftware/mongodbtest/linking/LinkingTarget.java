package be.smartsoftware.mongodbtest.linking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "TARGET")
public class LinkingTarget {
    @Id
    @Column(name = "TARGET_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long targetId;
    @Column(name = "TARGET_NAME", nullable = false)
    private String name;
    @Column(name = "TARGET_CURRENCY", nullable = false)
    private String currency;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Collection<LinkingCountry> countries;
}
