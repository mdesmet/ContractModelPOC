package be.smartsoftware.mongodbtest;


import be.smartsoftware.mongodbtest.linking.LinkingContract;
import be.smartsoftware.mongodbtest.mapper.ContractMapper;
import be.smartsoftware.mongodbtest.repo.ContractRepository;
import be.smartsoftware.mongodbtest.ui.UIContract;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import java.io.File;

@SpringBootApplication
public class ContractModelProofOfConcept implements CommandLineRunner {
    @Autowired
    private ContractRepository repository;

    @Autowired
    private ContractMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(ContractModelProofOfConcept.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // read json
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        ClassLoader classLoader = getClass().getClassLoader();
        UIContract testcontact = objectMapper.readValue(new File(classLoader.getResource("contract.json").getFile()), UIContract.class);
        logger.info(testcontact.toString());

        // saving in mongodb
        repository.save(testcontact);


        //  mapping to DB format
        for (UIContract contract : repository.findAll()) {
            logger.info(contract.toString());
            LinkingContract linkingContract = mapper.map(contract);
            logger.info(linkingContract.toString());
        }
        System.out.println();
    }
}
