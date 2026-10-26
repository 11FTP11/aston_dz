package ru.aston.homework.strategy;

import java.util.List;

interface NumberSearchStrategy {
    <T extends Number & Comparable<T>> T search(List<T> arr);
}
