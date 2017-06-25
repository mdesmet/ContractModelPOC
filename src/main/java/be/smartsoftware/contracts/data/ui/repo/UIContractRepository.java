package be.smartsoftware.contracts.data.ui.repo;

import be.smartsoftware.contracts.data.ui.UIContract;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UIContractRepository extends MongoRepository<UIContract, String> {
}
