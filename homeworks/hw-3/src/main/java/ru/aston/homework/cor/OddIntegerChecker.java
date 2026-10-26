package ru.aston.homework.cor;

class OddIntegerChecker extends NumberChecker<Integer> {
    
    @Override
    public boolean check(Integer value) {
	if ((value & 1) == 1) {
	    return false;
	}

	return this.checkNext(value);
    }
}
