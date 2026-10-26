package ru.aston.homework.cor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberCheckerTest {
    
    @Test
    public void shouldPassThroughChainWhenNumberIsPositiveAndEven() {
	NumberChecker<Integer> checker = NumberChecker.link(
		new NotNullChecker<>(),
		new PositiveIntegerChecker(),
		new EvenIntegerChecker()
	);
	
	assertTrue(checker.check(10));
    }
    
    @Test
    public void shouldFailWhenNumberIsOdd() {
	NumberChecker<Integer> checker = NumberChecker.link(
		new NotNullChecker<>(),
		new EvenIntegerChecker()
	);
	
	assertFalse(checker.check(3));
    }
	    
    @Test
    public void shouldFailWhenNumberIsNull() {
	NumberChecker<Integer> checker = NumberChecker.link(
		new NotNullChecker<>(),
		new PositiveIntegerChecker(),
		new EvenIntegerChecker()
	);
	
	assertFalse(checker.check(null));
    }
}

