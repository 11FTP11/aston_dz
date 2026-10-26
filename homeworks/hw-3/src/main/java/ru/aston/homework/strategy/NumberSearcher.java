package ru.aston.homework.strategy;

import java.util.List;


class NumberSearcher {
    private NumberSearchStrategy strategy;

    public void setStrategy(NumberSearchStrategy strategy) {
	this.strategy = strategy;
    }

    public NumberSearcher(NumberSearchStrategy strategy) {
	this.strategy = strategy;
    }

    public <T extends Number & Comparable<T>> T find(List<T> numbers) {
	return strategy.search(numbers);
    }
}
