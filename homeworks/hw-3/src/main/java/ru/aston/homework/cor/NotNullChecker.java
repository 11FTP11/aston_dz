package ru.aston.homework.cor;

class NotNullChecker<T extends Number & Comparable<T>> extends NumberChecker<T> {

    @Override
    public boolean check(T value) {
	if (value == null) {
	    return false;
	}
	
	return this.checkNext(value);
    }
}
