package com.nahwasa.study.tdd.citygas.charge;

import com.nahwasa.study.tdd.citygas.domain.CityGasUser;
import com.nahwasa.study.tdd.citygas.user.CityGasUserService;

import java.util.Optional;

public abstract class CityGasChargeService {
    private final CityGasUserService cityGasUserService;

    protected CityGasChargeService(CityGasUserService cityGasUserService) {
        this.cityGasUserService = cityGasUserService;
    }

    public long calculateCharge(long targetUserId) {
        Optional<CityGasUser> findUser = cityGasUserService.findUserById(targetUserId);
        CityGasUser user = findUser.orElseThrow(() -> new IllegalArgumentException("해당 유저 없어요!"));

        return calculateEachCharge(user);
    }

    public abstract long calculateEachCharge(CityGasUser user);
}
