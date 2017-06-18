package be.smartsoftware.mongodbtest;


import be.smartsoftware.mongodbtest.linking.LinkingContract;
import be.smartsoftware.mongodbtest.mapper.ContractMapper;
import be.smartsoftware.mongodbtest.repo.ContractRepository;
import be.smartsoftware.mongodbtest.ui.UIContract;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONTokener;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import java.io.File;
import java.io.InputStream;

@SpringBootApplication
public class ContractModelProofOfConcept implements CommandLineRunner {
    private ContractRepository repository;

    private ContractMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ContractModelProofOfConcept(ContractRepository repository, ContractMapper mapper) {
        this.repository = repository;
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
        InputStream contractSchemaInputStream = getClass().getResourceAsStream("/contract-schema.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(contractSchemaInputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        JSONObject rawInput = new JSONObject(new JSONTokener(getClass().getResourceAsStream("/contract.json")));
        try {
            schema.validate(rawInput);
        }catch(ValidationException e) {
            logger.error(e.getMessage());
            e.getCausingExceptions().stream()
                    .map(ValidationException::getMessage)
                    .forEach(logger::error);
        }

        // saving in mongodb
        repository.save(testcontact);

        //  mapping to DB format
        for (UIContract contract : repository.findAll()) {
            logger.info(contract.toString());
            LinkingContract linkingContract = mapper.map(contract);
            logger.info(linkingContract.toString());

            // save in db
            // not implemented
        }

        System.exit(0);
    }
}
