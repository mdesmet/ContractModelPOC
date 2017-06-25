package be.smartsoftware.contracts.data.reference.repo;


import be.smartsoftware.contracts.data.reference.ReferenceCountry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReferenceCountryRepository extends MongoRepository<ReferenceCountry, String> {
}
