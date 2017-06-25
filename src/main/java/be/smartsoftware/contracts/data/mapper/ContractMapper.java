package be.smartsoftware.contracts.data.mapper;

import be.smartsoftware.contracts.data.linking.LinkingContract;
import be.smartsoftware.contracts.data.linking.LinkingTarget;
import be.smartsoftware.contracts.data.ui.UIContract;
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
                .map(target -> targetMapper.map(target, contract))
                .flatMap(Collection::stream)
                .collect(toList());

        return LinkingContract.builder().name(contract.getName()).targets(linkingTargets).build();
    }
}
