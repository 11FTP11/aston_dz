package ru.aston.homework.bank;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void when_makingDeposit_then_increaseBalance() {
        BankAccount account = new BankAccount("acc1", "500.00");

        account.applyOperation(new Deposit(new BigDecimal("300.00")));
        assertEquals(new BigDecimal("800.00"), account.getBalance());
    }

    @Test
    void when_makingDepositWithZeroValue_then_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Deposit(BigDecimal.ZERO);
        });
    }
    
    @Test
    void when_makingDepositWithNull_then_NullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            new Deposit(null);
        });
    }

    @Test
    void when_makingDepositWithNegativeValue_then_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Deposit(new BigDecimal("-50.00"));
        });
    }

    @Test
    void when_makingWithdraw_then_decreaseBalance() {
        BankAccount account = new BankAccount("acc1", "1000.00");
        account.applyOperation(new Withdraw(new BigDecimal("400.00")));
        assertEquals(new BigDecimal("600.00"), account.getBalance());
    }

    @Test
    void when_makingWithdrawWithZeroBalance_then_IllegalStateException() {
        BankAccount account = new BankAccount("acc1", "0.00");

        assertThrows(IllegalStateException.class, () -> {
            account.applyOperation(new Withdraw(new BigDecimal("100.00")));
        });
    }

    @Test
    void when_makingWithdrawWithNegativeValue_then_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Withdraw(new BigDecimal("-10.00"));
        });
    }

    @Test
    void when_makingWithdrawWithZeroValue_then_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Withdraw(BigDecimal.ZERO);
        });
    }
    
    @Test
    void when_makingWithdrawWithNull_then_NullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            new Withdraw(null);
        });
    }
}
