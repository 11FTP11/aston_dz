package ru.aston.homework.decorator;


abstract class TextHolderDecorator implements TextHolder {
    protected final TextHolder wrapee;

    public TextHolderDecorator(TextHolder wrapee) {
	this.wrapee = wrapee;
    }

    @Override
    public String getText() {
	return wrapee.getText();
    }
}
