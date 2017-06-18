package be.smartsoftware.mongodbtest.linking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "CONTRACT")
public class LinkingContract {
    @Id
    @Column(name = "CONTRACT_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long contractId;
    @Column(name = "CONTRACT_NAME", nullable = false)
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Collection<LinkingTarget> targets;
}
