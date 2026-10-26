package ru.aston.homework.strategy;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

class NumberSearcherTest {

    @Test
    public void shouldReturnFirst() {
	NumberSearcher searcher = new NumberSearcher(new FirstNumberStrategy());
	Integer value = searcher.find(List.of(1, 2, 3, 4, 5, 6, 7));
	assertEquals(1, value);
    }
    
    @Test
    public void shouldReturnLast() {
	NumberSearcher searcher = new NumberSearcher(new LastNumberStrategy());
	Integer value = searcher.find(List.of(1, 2, 3, 4, 5, 6, 7));
	assertEquals(7, value);
    }
    
    @Test
    public void shouldReturnFirstAndLast() {
	NumberSearcher searcher = new NumberSearcher(new FirstNumberStrategy());
	Integer value = searcher.find(List.of(1, 2, 3, 4, 5, 6, 7));
	assertEquals(1, value);
	
	searcher.setStrategy(new LastNumberStrategy());
	value = searcher.find(List.of(1, 2, 3, 4, 5, 6, 7));
	assertEquals(7, value);
    }
    
    @Test
    public void shouldReturnWithCustom() {
	//find max value
	NumberSearcher searcher = new NumberSearcher(new NumberSearchStrategy() {
		@Override
		public <T extends Number & Comparable<T>> T search(List<T> arr) {
		    if (arr == null || arr.isEmpty()) {
			return null;
		    }

		    return arr
			.stream()
			.max(Comparator.naturalOrder())
			.get();
		}
	    });

	Integer value = searcher.find(List.of(1, 5, 10, -1, 20, 0, 3, 5));
	assertEquals(20, value);
    }

}

