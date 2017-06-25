package be.smartsoftware.contracts.rest;

import be.smartsoftware.contracts.data.reference.ReferenceCountry;
import be.smartsoftware.contracts.data.reference.repo.ReferenceCountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@Slf4j
public class CountriesController {
    private ReferenceCountryRepository referenceCountryRepository;
    @Autowired
    public CountriesController(ReferenceCountryRepository referenceCountryRepository) {
        this.referenceCountryRepository = referenceCountryRepository;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ReferenceCountry>> listAllCountries() {
        log.info("Fetching all countries");
        List<ReferenceCountry> countries = referenceCountryRepository.findAll();
        if (countries.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}
