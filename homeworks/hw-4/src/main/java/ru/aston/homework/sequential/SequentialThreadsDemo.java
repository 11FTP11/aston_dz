package ru.aston.homework.sequential;

import java.util.concurrent.Semaphore;

class SequentialThreadsDemo {
    static final String FIRST_VALUE = "1";
    static final String SECOND_VALUE = "2";
    
    public static Thread threadLoopPrint(Semaphore sem1, Semaphore sem2, String value) {
        return new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    sem1.acquire();
                    System.out.println(value);
                    sem2.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    public static void main(String[] args) {
        
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);

        Thread t1 = threadLoopPrint(s1, s2, FIRST_VALUE);
        Thread t2 = threadLoopPrint(s2, s1, SECOND_VALUE);
        
        t1.start();
        t2.start();
    }

}
