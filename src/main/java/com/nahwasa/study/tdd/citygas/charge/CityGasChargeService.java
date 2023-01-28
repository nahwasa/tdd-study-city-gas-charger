package com.nahwasa.study.tdd.citygas.charge;

import com.nahwasa.study.tdd.citygas.domain.CityGasChargeType;
import com.nahwasa.study.tdd.citygas.domain.CityGasUser;
import com.nahwasa.study.tdd.citygas.user.CityGasUserService;

import java.util.Optional;

public class CityGasChargeService {
    private final CityGasUserService cityGasUserService;

    public CityGasChargeService(CityGasUserService cityGasUserService) {
        this.cityGasUserService = cityGasUserService;
    }

    public long calculateCharge(long targetUserId, CityGasChargeType type) {
        Optional<CityGasUser> findUser = cityGasUserService.findUserById(targetUserId);
        CityGasUser user = findUser.orElseThrow(() -> new IllegalArgumentException("해당 유저 없어요!"));
        long unitPrice = user.getUnitPrice();
        long usage = user.getUsage();

        if (type == CityGasChargeType.REGULAR)
            return unitPrice * usage;
        else if (type == CityGasChargeType.VULNERABLE)
            return unitPrice * usage * 80 / 100;

        throw new IllegalArgumentException("존재하지 않는 요금 계산 타입임 ㅠ");
    }
}
