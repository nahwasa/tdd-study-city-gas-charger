package com.nahwasa.study.tdd.citygas.charge;

import com.nahwasa.study.tdd.citygas.domain.CityGasUser;
import com.nahwasa.study.tdd.citygas.user.CityGasUserService;

import java.util.Optional;

public class CityGasChargeService {
    private final CityGasUserService cityGasUserService;

    public CityGasChargeService(CityGasUserService cityGasUserService) {
        this.cityGasUserService = cityGasUserService;
    }

    public long calculateCharge(long targetUserId) {
        Optional<CityGasUser> findUser = cityGasUserService.findUserById(targetUserId);
        CityGasUser user = findUser.orElseThrow(() -> new IllegalArgumentException("해당 유저 없어요!"));
        long unitPrice = user.getUnitPrice();
        long usage = user.getUsage();
        return unitPrice * usage;
    }
}
