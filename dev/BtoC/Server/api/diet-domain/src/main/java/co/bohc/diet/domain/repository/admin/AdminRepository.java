package co.bohc.diet.domain.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import co.bohc.diet.domain.model.MAdminUser;

public interface AdminRepository extends JpaRepository<MAdminUser, Integer>{

    public MAdminUser findByLoginId(@Param("loginId")String loginId);
}
