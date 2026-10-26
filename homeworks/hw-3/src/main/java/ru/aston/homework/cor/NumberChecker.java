package ru.aston.homework.cor;

abstract class NumberChecker<T extends Number & Comparable<T>> {
    private NumberChecker<T> next;

    public NumberChecker<T> setNext(NumberChecker<T> next) {
	this.next = next;
	return next;
    }
    
    public abstract boolean check(T value);

    protected boolean checkNext(T value) {
	if (this.next == null) {
	    return true;
	}

	return next.check(value);
    }

    @SafeVarargs
    public static <T extends Number & Comparable<T>> NumberChecker<T> link(NumberChecker<T> head, NumberChecker<T>... others) {
	NumberChecker<T> first = head;
	for (NumberChecker<T> checker: others) {
	    first = first.setNext(checker);
	}
	
	return head;
    }
}
