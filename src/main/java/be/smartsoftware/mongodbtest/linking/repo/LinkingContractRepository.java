package be.smartsoftware.mongodbtest.linking.repo;

import be.smartsoftware.mongodbtest.linking.LinkingContract;
import org.springframework.data.repository.CrudRepository;

public interface LinkingContractRepository extends CrudRepository<LinkingContract, Long> {
}
