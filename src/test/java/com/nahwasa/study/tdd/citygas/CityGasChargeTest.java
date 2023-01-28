package com.nahwasa.study.tdd.citygas;

import com.nahwasa.study.tdd.citygas.charge.CityGasChargeService;
import com.nahwasa.study.tdd.citygas.domain.CityGasUser;
import com.nahwasa.study.tdd.citygas.user.CityGasUserRepository;
import com.nahwasa.study.tdd.citygas.user.CityGasUserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@DisplayName("TDD 스터디에서 만드는 도시가스 요금 계산은")
@ExtendWith(MockitoExtension.class)
public class CityGasChargeTest {

    @Mock
    CityGasUserRepository repository;

    @Test
    @DisplayName("단위 요금 x 사용량으로 요금을 계산할 수 있어야 한다.")
    void city_gas_charge() {
        // given
        long unitPrice = 5;
        long usage = 10;
        CityGasUser user = new CityGasUser(unitPrice, usage);
        CityGasUserService cityGasUserService = new CityGasUserService(repository);
        CityGasChargeService cityGasChargeService = new CityGasChargeService(cityGasUserService);
        given(repository.findById(1L)).willReturn(Optional.of(user));

        // when
        cityGasUserService.add(user);
        long targetUserId = 1L;
        long result = cityGasChargeService.calculateCharge(targetUserId);

        // then
        then(repository).should(times(1)).save(user);
        Assertions.assertThat(result).isEqualTo(50L);
    }
}
