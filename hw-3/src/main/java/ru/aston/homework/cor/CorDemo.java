package ru.aston.homework.cor;

public class CorDemo {
    public static void main(String[] args) {
	
         NumberChecker<Integer> checker = NumberChecker.link(
            new NotNullChecker<>(),
            new PositiveIntegerChecker(),
            new EvenIntegerChecker()
        );

	Integer[] testValues = {10, 3, -4, null, 6};

        System.out.println("Chain: NotNull -> PositiveInteger -> EvenInteger");
        System.out.println("--------------------------------------------------");

        for (Integer value : testValues) {
            boolean isValid = checker.check(value);
	    System.out.printf("Value: %s check passed: %b\n", value, isValid);
        }
    }
}
