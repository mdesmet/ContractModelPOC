package be.smartsoftware.mongodbtest.repo;

import be.smartsoftware.mongodbtest.ui.UIContract;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by mdesm on 17-Jun-17.
 */
public interface ContractRepository  extends MongoRepository<UIContract, String> {
    UIContract findById(String id);
}
