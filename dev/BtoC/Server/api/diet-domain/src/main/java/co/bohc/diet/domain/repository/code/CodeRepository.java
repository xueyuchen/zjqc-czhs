package co.bohc.diet.domain.repository.code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.bohc.diet.domain.model.Code;

public interface CodeRepository extends JpaRepository<Code, Integer>{

    public Code findByCodeNum(String codeNum);
}
