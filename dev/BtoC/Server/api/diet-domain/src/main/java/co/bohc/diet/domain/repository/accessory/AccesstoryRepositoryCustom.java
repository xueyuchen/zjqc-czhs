package co.bohc.diet.domain.repository.accessory;

import java.util.List;

public interface AccesstoryRepositoryCustom {

    public List<AccessoryOutput> findByParam(AccessorySearchPar accessorySearchPar);
}
