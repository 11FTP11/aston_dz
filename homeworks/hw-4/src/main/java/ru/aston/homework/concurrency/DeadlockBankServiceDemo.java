package ru.aston.homework.concurrency;

import ru.aston.homework.bank.Deposit;
import ru.aston.homework.bank.Withdraw;
import ru.aston.homework.bank.Account;
import ru.aston.homework.bank.BankAccount;
import java.math.BigDecimal;

class DeadlockBankServiceDemo {
    public static void transfer(Account from, Account to, BigDecimal amount) {
        String threadName = Thread.currentThread().getName();
        synchronized(from) {
            System.out.printf("[\"%s\"]: acquired sender account (\"%s\")\n", threadName,  from.getName());
            
            System.out.printf("[\"%s\"]: trying to acquire receiver account (\"%s\")...\n", threadName, to.getName());
            synchronized(to) {
                try {
                    from.applyOperation(new Withdraw(amount));            
                    to.applyOperation(new Deposit(amount));                
                    System.out.printf("[\"%s\"]: succesful ended transfer with receiver (\"%s\") and sender (\"%s\")\n", threadName, from.getName(), to.getName());
                } catch (IllegalStateException | IllegalArgumentException | NullPointerException e) {
                    System.out.printf("[\"%s\"]: transfer error -> %s\n", threadName, e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("acc1", "1200");
        BankAccount acc2 = new BankAccount("acc2", "890");

        Thread t1 = new Thread(() -> {
            transfer(acc1, acc2, new BigDecimal("300.00"));
        }, "Thread-1");
        
        Thread t2 = new Thread(() -> {
            transfer(acc2, acc1, new BigDecimal("100.00"));
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
