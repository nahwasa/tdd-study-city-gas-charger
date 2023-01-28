package com.nahwasa.study.tdd.citygas.domain;

import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

public class CityGasUser {
    @Id
    @GeneratedValue
    private long userId;

    private long unitPrice;
    private long usage;

    public CityGasUser(long unitPrice, long usage) {
        this.unitPrice = unitPrice;
        this.usage = usage;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public long getUsage() {
        return usage;
    }

    public void setUsage(long usage) {
        this.usage = usage;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
