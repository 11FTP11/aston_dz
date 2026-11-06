package ru.aston.homework.bank;

import java.math.BigDecimal;

@FunctionalInterface
public interface BalanceOperation {
    BigDecimal execute(BigDecimal value);
}
