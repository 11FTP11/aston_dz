package ru.aston.homework.builder;

public class BuilderDemo {
    public static void main(String[] args) {
	System.out.println("\nBuilding a profile with all fields filled in");
	System.out.println("-------------------------");

	UserProfile ivan = new UserProfile.Builder()
	    .username("Ivan")
	    .phoneNumber("+79991112233")
	    .age((short) 25)
	    .email("ivan@example.com")
	    .build();

        System.out.println(ivan);
	System.out.println("\nBuilding a profile with some fields filled in");
        System.out.println("--------------------------");

	UserProfile petya = new UserProfile.Builder()
	    .username("Petya")
	    .age((short) 13)
	    .build();

        System.out.println(petya);
    }
}
