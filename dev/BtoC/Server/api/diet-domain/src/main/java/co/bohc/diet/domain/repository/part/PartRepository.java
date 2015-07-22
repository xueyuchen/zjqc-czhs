package co.bohc.diet.domain.repository.part;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.bohc.diet.domain.model.Part;

public interface PartRepository extends JpaRepository<Part, Integer> {

    @Query(value = "SELECT p FROM Part p WHERE p.delFlg IS NULL ORDER BY p.partName")
    public List<Part> findAllByDelFlg();
}
