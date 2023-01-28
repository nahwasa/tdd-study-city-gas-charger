package com.nahwasa.study.tdd.citygas.user;

import com.nahwasa.study.tdd.citygas.domain.CityGasUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityGasUserRepository extends JpaRepository<CityGasUser, Long> {
}
