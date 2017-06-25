package be.smartsoftware.contracts.data.ui.validator;

import be.smartsoftware.contracts.data.reference.repo.ReferenceCountryRepository;
import be.smartsoftware.contracts.data.ui.UICountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class ValidCountryConstraintValidator implements ConstraintValidator<ValidCountry, List<UICountry>> {
    private ReferenceCountryRepository referenceCountryRepository;

    @Autowired
    public ValidCountryConstraintValidator(ReferenceCountryRepository referenceCountryRepository) {
        this.referenceCountryRepository = referenceCountryRepository;
    }

    @Override
    public void initialize(ValidCountry validCountry) {

    }

    @Override
    public boolean isValid(List<UICountry> countries, ConstraintValidatorContext constraintValidatorContext) {
        try {
            countries.forEach(country -> {
                if(referenceCountryRepository.findAll()
                        .stream()
                        .noneMatch(referenceCountry -> {
                            if(country == null || referenceCountry == null)
                                return false;
                            return country.getCode().equals(referenceCountry.getCode());
                        }))
                    throw new RuntimeException();
            });
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }
}
