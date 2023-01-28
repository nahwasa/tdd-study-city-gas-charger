package com.nahwasa.study.tdd.citygas;

import com.nahwasa.study.tdd.citygas.charge.CityGasChargeService;
import com.nahwasa.study.tdd.citygas.domain.CityGasUser;
import com.nahwasa.study.tdd.citygas.user.CityGasUserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TDD 스터디에서 만드는 도시가스 요금 계산은")
public class CityGasChargeTest {

    @Test
    @DisplayName("단위 요금 x 사용량으로 요금을 계산할 수 있어야 한다.")
    void city_gas_charge() {
        // given
        long unitPrice = 5;
        long usage = 10;
        CityGasUser user = new CityGasUser(unitPrice, usage);
        CityGasUserService cityGasUserService = new CityGasUserService(repository);
        CityGasChargeService cityGasChargeService = new CityGasChargeService(cityGasUserService);

        // when
        cityGasUserService.add(user);
        long targetUserId = 1L;
        long result = cityGasChargeService.calculateCharge(targetUserId);

        // then
        Assertions.assertThat(result).isEqualTo(50L);
    }
}
