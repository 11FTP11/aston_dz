package ru.aston.homework.strategy;

import java.util.List;

public class StrategyDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 12, 3, 8, 19, 24, 7, 10);

        System.out.println("reference: " + numbers);
        System.out.println("--------------------------------------------------");
        NumberSearcher searcher = new NumberSearcher(
	   new FirstNumberStrategy()
	);

        System.out.println("First number (using first number strategy): " + searcher.find(numbers));

        searcher.setStrategy(new LastNumberStrategy());
        System.out.println("Last number (using last number strategy): " + searcher.find(numbers));
    }
}
