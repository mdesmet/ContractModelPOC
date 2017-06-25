package be.smartsoftware.contracts.rest;

import be.smartsoftware.contracts.data.ui.UIContract;
import be.smartsoftware.contracts.data.ui.repo.UIContractRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/api/contracts")
@Slf4j
public class ContractsController {

    private UIContractRepository uiContractRepository;
    @Autowired
    public ContractsController(UIContractRepository uiContractRepository) {
        this.uiContractRepository = uiContractRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<UIContract>> listAllContracts() {
        log.info("Fetching all contracts");
        List<UIContract> contracts = uiContractRepository.findAll();
        if (contracts.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    @RequestMapping(value = "/contract/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getContract(@PathVariable("id") String id) {
        log.info("Fetching contract with id {}", id);
        UIContract contract = uiContractRepository.findOne(id);
        if (contract == null) {
            log.info("Contract with id {} not found.", id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }


    @RequestMapping(value = "/contract/", method = RequestMethod.POST)
    public ResponseEntity<?> createContract(@Validated @RequestBody UIContract contract, UriComponentsBuilder ucBuilder) {
        log.info("Creating contract : {}", contract);
        uiContractRepository.save(contract);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/contracts/contract/{id}").buildAndExpand(contract.getId()).toUri());
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/contract/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateContract(@PathVariable("id") String id, @RequestBody UIContract contract) {
        log.info("Updating contract with id {}", id);
        UIContract currentContract = uiContractRepository.findOne(id);
        if (currentContract == null) {
            log.info("Contract with id {} not found.", id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        currentContract.setName(contract.getName());
        currentContract.setVersion(contract.getVersion());
        currentContract.setCurrency(contract.getCurrency());
        currentContract.setCountries(contract.getCountries());
        currentContract.setTargets(contract.getTargets());
        currentContract.setActive(contract.getActive());
        uiContractRepository.save(currentContract);
        return new ResponseEntity<>(currentContract, HttpStatus.OK);
    }


    @RequestMapping(value = "/contract/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteContract(@PathVariable("id") String id) {
        log.info("Fetching & Deleting contract with id {}", id);

        UIContract currentContract = uiContractRepository.findOne(id);
        if (currentContract == null) {
            log.info("Contract with id {} not found.", id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        uiContractRepository.delete(currentContract);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
