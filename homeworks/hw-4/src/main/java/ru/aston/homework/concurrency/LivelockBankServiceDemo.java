package ru.aston.homework.concurrency;

import ru.aston.homework.bank.Deposit;
import ru.aston.homework.bank.Withdraw;
import ru.aston.homework.bank.BankAccount;
import java.math.BigDecimal;

class LivelockBankServiceDemo {
    public static <T extends BankAccount & Lockable> void transfer(T from, T to, BigDecimal amount) {
        String threadName = Thread.currentThread().getName();
        boolean fromLock = false;
        boolean toLock = false;
        try {
            while (true) {
                fromLock = from.getLock().tryLock();
                if (fromLock)
                    System.out.printf("[\"%s\"]: acquired sender account (\"%s\")\n", threadName,  from.getName());
                
                toLock = to.getLock().tryLock();
                if (toLock)
                    System.out.printf("[\"%s\"]: acquired receiver account (\"%s\")\n", threadName,  to.getName());
                
                if (fromLock && toLock) {
                    System.out.printf("[\"%s\"]: successful acquired both accounts", threadName);
                    break;
                }

                if (fromLock && !toLock) {
                    System.out.printf("[\"%s\"]: receiver is busy. Unlocking sender...", threadName);
                    from.getLock().unlock();
                    fromLock = false;
                }
                
                if (toLock && !fromLock) {
                    System.out.printf("[\"%s\"]: sender is busy. Unlocking receiver...", threadName);
                    to.getLock().unlock();
                    toLock = false;
                }
            }
            
            from.applyOperation(new Withdraw(amount));                        
            to.applyOperation(new Deposit(amount));                
            System.out.printf("[\"%s\"]: succesful ended transfer with receiver (\"%s\") and sender (\"%s\")\n", threadName, from.getName(), to.getName());
        } finally {
            if (fromLock) from.getLock().unlock();
            if (toLock) from.getLock().unlock();
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
