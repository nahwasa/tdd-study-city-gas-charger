package com.nahwasa.study.tdd.citygas.user;

import com.nahwasa.study.tdd.citygas.domain.CityGasUser;

import java.util.Optional;

public class CityGasUserService {
    private final CityGasUserRepository repository;

    public CityGasUserService(CityGasUserRepository repository) {
        this.repository = repository;
    }

    public void add(CityGasUser user) {
        repository.save(user);
    }

    public Optional<CityGasUser> findUserById(long targetUserId) {
        return repository.findById(targetUserId);
    }
}
