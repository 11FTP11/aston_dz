package ru.aston.homework.cor;


class PositiveIntegerChecker extends NumberChecker<Integer> {
    
    @Override
    public boolean check(Integer value) {
	if (value < 0) {
	    return false;
	}

	return this.checkNext(value);
    }
}
