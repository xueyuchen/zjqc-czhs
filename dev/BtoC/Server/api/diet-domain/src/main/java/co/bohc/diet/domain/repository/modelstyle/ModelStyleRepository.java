package co.bohc.diet.domain.repository.modelstyle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.bohc.diet.domain.model.ModelStyle;

public interface ModelStyleRepository extends JpaRepository<ModelStyle, Integer> {

    @Query(value = "SELECT m FROM ModelStyle m WHERE m.model.modelId = :modelId AND m.delFlg IS NULL ORDER BY m.style.styleName")
    public List<ModelStyle> findByDelFlg(@Param("modelId")Integer modelId);
}
