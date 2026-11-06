package ru.aston.homework.bank;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import ru.aston.homework.concurrency.Lockable;

public class BankAccount implements Account, Lockable {
    private final String name;
    private final Lock lock = new ReentrantLock();    
    private BigDecimal balance;

    @Override
    public Lock getLock() {
        return this.lock;
    }
    
    @Override
    public BigDecimal getBalance() {
        return this.balance;
    }

    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public void applyOperation(BalanceOperation op) {
        this.balance = op.execute(this.balance);
    }

    public BankAccount(String name, String balance) {
        this.name = name;
        this.balance = new BigDecimal(balance);
    }
}
