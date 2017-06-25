package be.smartsoftware.contracts.data.linking.repo;

import be.smartsoftware.contracts.data.linking.LinkingContract;
import org.springframework.data.repository.CrudRepository;

public interface LinkingContractRepository extends CrudRepository<LinkingContract, Long> {
}
