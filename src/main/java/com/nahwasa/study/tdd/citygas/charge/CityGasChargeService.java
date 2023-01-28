package com.nahwasa.study.tdd.citygas.charge;

import com.nahwasa.study.tdd.citygas.domain.CityGasUser;
import com.nahwasa.study.tdd.citygas.user.CityGasUserService;

public class CityGasChargeService extends AbstractCityGasChargeService {

    public CityGasChargeService(CityGasUserService cityGasUserService) {
        super(cityGasUserService);
    }

    @Override
    public long calculateEachCharge(CityGasUser user) {
        long unitPrice = user.getUnitPrice();
        long usage = user.getUsage();

        return unitPrice * usage;
    }
}
