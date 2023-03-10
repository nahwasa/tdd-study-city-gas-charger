package com.nahwasa.study.tdd.citygas.charge;

import com.nahwasa.study.tdd.citygas.domain.CityGasUser;
import com.nahwasa.study.tdd.citygas.user.CityGasUserService;

public class VulnerableCityGasChargeService extends CityGasChargeService {
    private final int discountRate;

    public VulnerableCityGasChargeService(CityGasUserService cityGasUserService, int discountRate) {
        super(cityGasUserService);
        this.discountRate = discountRate;
    }

    @Override
    public long calculateEachCharge(CityGasUser user) {
        long unitPrice = user.getUnitPrice();
        long usage = user.getUsage();

        return unitPrice * usage * (100-discountRate) / 100;
    }
}
