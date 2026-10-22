package ru.aston.homework.strategy;

@FunctionalInterface
interface NumberSearchStrategy {
    <T extends Number & Comparable<T>> T search(List<T> arr);
}
