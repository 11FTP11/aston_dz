package ru.aston.homework.decorator;

public class PlainTextHolder implements TextHolder {
    private final String text;

    public PlainTextHolder(String text) {
	this.text = text;
    }

    @Override
    public String getText() {
	return this.text;
    }
}
