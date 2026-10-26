package ru.aston.homework.cor;

class EvenIntegerChecker extends NumberChecker<Integer> {
    
    @Override
    public boolean check(Integer value) {
	if ((value & 1) != 0) {
	    return false;
	}

	return this.checkNext(value);
    }
}
