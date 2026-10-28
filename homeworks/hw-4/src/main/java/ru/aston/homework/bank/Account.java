package ru.aston.homework.bank;

import java.math.BigDecimal;

public interface Account {
    BigDecimal getBalance();
    String getName();
    void applyOperation(BalanceOperation op);
}
