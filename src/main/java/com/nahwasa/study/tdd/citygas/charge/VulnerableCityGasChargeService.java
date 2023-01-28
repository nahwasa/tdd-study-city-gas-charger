package com.nahwasa.study.tdd.citygas.charge;

import com.nahwasa.study.tdd.citygas.user.CityGasUserService;

public class VulnerableCityGasChargeService extends CityGasChargeService {

    public VulnerableCityGasChargeService(CityGasUserService cityGasUserService) {
        super(cityGasUserService);
    }

    @Override
    public long calculateCharge(long targetUserId) {
        long regularCharge = super.calculateCharge(targetUserId);
        return regularCharge * 80 / 100;
    }
}
