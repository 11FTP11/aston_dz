package ru.aston.homework.concurrency;

import java.util.concurrent.locks.Lock;

public interface Lockable {
    Lock getLock();
}
