package ru.aston.homework.decorator;

import java.util.stream.Collectors;
import java.util.Arrays;
    
class KebabDecorator extends TextHolderDecorator {

    public KebabDecorator(TextHolder wrapee) {
	super(wrapee);
    }

    @Override
    public String getText() {
	String original = this.wrapee.getText();
	if ((original == null) || (original.isBlank())) {
	    return original;
	}

	return original.chars()
	    .filter(sym -> !Character.isWhitespace(sym))
	    .mapToObj(value -> String.valueOf((char) value))
	    .collect(Collectors.joining("-"));

    }
}
