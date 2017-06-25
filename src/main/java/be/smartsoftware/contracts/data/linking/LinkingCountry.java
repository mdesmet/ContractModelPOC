package be.smartsoftware.contracts.data.linking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "COUNTRY")
public class LinkingCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COUNTRY_ID")
    private Long id;
    @Column(name = "COUNTRY_NAME", nullable = false)
    public String name;
    @Column(name = "COUNTRY_CODE", nullable = false)
    public String code;
    @Column(name = "COUNTRY_CURRENCY", nullable = false)
    public String currency;
}
