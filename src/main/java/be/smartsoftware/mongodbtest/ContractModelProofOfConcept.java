package be.smartsoftware.mongodbtest;


import be.smartsoftware.mongodbtest.linking.LinkingContract;
import be.smartsoftware.mongodbtest.linking.repo.LinkingContractRepository;
import be.smartsoftware.mongodbtest.mapper.ContractMapper;
import be.smartsoftware.mongodbtest.ui.UIContract;
import be.smartsoftware.mongodbtest.ui.repo.UIContractRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class ContractModelProofOfConcept implements CommandLineRunner {
    private final UIContractRepository repository;
    private final LinkingContractRepository linkingContractRepository;
    private final ContractMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ContractModelProofOfConcept(UIContractRepository repository,
                                       LinkingContractRepository linkingContractRepository,
                                       ContractMapper mapper) {
        this.repository = repository;
        this.linkingContractRepository = linkingContractRepository;
        this.mapper = mapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(ContractModelProofOfConcept.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        // read json
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        UIContract testcontact = objectMapper.readValue(
                getClass().getResourceAsStream("/contract.json"), UIContract.class);
        logger.info(testcontact.toString());

        // validate the json
        JSONObject rawSchema = new JSONObject(new JSONTokener(
                getClass().getResourceAsStream("/contract-schema.json")));
        Schema schema = SchemaLoader.load(rawSchema);
        JSONObject rawInput = new JSONObject(new JSONTokener(
                getClass().getResourceAsStream("/contract.json")));
        try {
            schema.validate(rawInput);
        } catch (ValidationException e) {
            logger.error(e.getMessage());
            e.getCausingExceptions().stream()
                    .map(ValidationException::getMessage)
                    .forEach(logger::error);

        }

        // saving in mongodb
        repository.save(testcontact);

        // map to linking DB format and save in in-memory db
        repository.findAll()
                .forEach(
                        contract -> {
                            logger.info(contract.toString());
                            LinkingContract linkingContract = mapper.map(contract);
                            logger.info(linkingContract.toString());
                            linkingContractRepository.save(linkingContract);
                        }
                );

        // clear session to simulate another http call
        entityManager.clear();

        // get from in-memory DB
        logger.info(linkingContractRepository.findAll().toString());
        System.exit(0);
    }
}
