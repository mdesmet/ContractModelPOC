package be.smartsoftware.mongodbtest.ui.repo;

import be.smartsoftware.mongodbtest.ui.UIContract;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UIContractRepository extends MongoRepository<UIContract, String> {
}
