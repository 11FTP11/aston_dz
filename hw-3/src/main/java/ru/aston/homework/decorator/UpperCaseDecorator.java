package ru.aston.homework.decorator;

class UpperCaseDecorator extends TextHolderDecorator {

    public UpperCaseDecorator(TextHolder wrapee) {
	super(wrapee);
    }

    @Override
    public String getText() {
	String original = this.wrapee.getText();
	return original == null
	    ? original
	    : original.toUpperCase();
    }
}
