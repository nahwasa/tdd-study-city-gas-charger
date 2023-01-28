package com.nahwasa.study.tdd.citygascharger;

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
        CityGasChargeService cityGasChargeService = new CityGasChargeService();

        // when
        long targetUserId = 1L;
        long charge = cityGasCharge.calculateCharge(targetUserId);

        // then
        Assertions.assertThat(charge).isEqualTo(50L);
    }
}
