package ru.aston.homework.strategy;

import java.util.List;

class LastNumberStrategy implements NumberSearchStrategy {
    @Override
    public <T extends Number & Comparable<T>> T search(List<T> arr) {
	if (arr == null || arr.isEmpty()) {
	    return null;
	}
	
	return arr.getLast();
    }
}



