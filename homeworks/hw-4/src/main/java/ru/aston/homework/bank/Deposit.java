package ru.aston.homework.bank;

import java.math.BigDecimal;
import java.util.Objects;

public class Deposit implements BalanceOperation {
    private final BigDecimal amount;

    public Deposit(BigDecimal amount) {
        Objects.requireNonNull(amount, "Amount cannot be null");
        
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        
        this.amount = amount;
    }

    @Override
    public BigDecimal execute(BigDecimal currentBalance) {
        Objects.requireNonNull(currentBalance, "Current balance cannot be null");
        
        return currentBalance.add(amount);
    }
}
