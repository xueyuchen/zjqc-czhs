package co.bohc.diet.domain.repository.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.bohc.diet.domain.model.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

    @Query(value = "SELECT m FROM Model m WHERE m.brand.brandId = :brandId AND m.delFlg IS NULL")
    public List<Model> findAllBydelFlg(@Param("brandId")Integer brandId);
}
