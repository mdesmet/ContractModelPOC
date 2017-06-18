package be.smartsoftware.mongodbtest.mapper;

import be.smartsoftware.mongodbtest.linking.LinkingContract;
import be.smartsoftware.mongodbtest.linking.LinkingTarget;
import be.smartsoftware.mongodbtest.ui.UIContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Component
public class ContractMapper {
    private final TargetMapper targetMapper;

    @Autowired
    public ContractMapper(TargetMapper targetMapper) {
        this.targetMapper = targetMapper;
    }

    public LinkingContract map(UIContract contract) {
        Collection<LinkingTarget> linkingTargets = contract
                .getTargets()
                .stream()
                .map(targetMapper::map)
                .flatMap(Collection::stream)
                .collect(toList());

        return LinkingContract.builder().name(contract.getName()).targets(linkingTargets).build();
    }
}
