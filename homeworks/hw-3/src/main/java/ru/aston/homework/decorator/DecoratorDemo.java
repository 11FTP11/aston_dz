package ru.aston.homework.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        String originalText = "example words";

        System.out.println("------------------------------");
 
        TextHolder plain = new PlainTextHolder(originalText);
        System.out.printf("Plain text: %s\n", plain.getText());
 
        TextHolder upper = new UpperCaseDecorator(
	   new PlainTextHolder(originalText)
	);
	
        System.out.printf("Upper case letters: %s\n", upper.getText());
 
        TextHolder kebab = new KebabDecorator(
	    upper
	);
	
        System.out.printf("Kebab with upper case letters: %s\n", kebab.getText());
    }
}
