package ru.aston.homework.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextHolderDecoratorTest {
    
    @Test
    void shouldReturnOriginalText() {
        TextHolder holder = new PlainTextHolder("hello world");
        
        assertEquals("hello world", holder.getText());
    }

    @Test
    void shouldConvertTextToUpperCase() {
        TextHolder holder = new UpperCaseDecorator(
            new PlainTextHolder("hello world")
        );
        
        assertEquals("HELLO WORLD", holder.getText());
    }
    
    @Test
    void shouldConvertToKebabWhenUpperCaseIsApplied() {
        TextHolder holder = new KebabDecorator(
	    new UpperCaseDecorator(new PlainTextHolder("hello world"))
	);
        
        assertEquals(
	    "H-E-L-L-O-W-O-R-L-D",
	    holder.getText(),
	    "failed: KebabDecorator(UpperCaseDecorator(...))"
	);
	
	holder = new UpperCaseDecorator(
	    new KebabDecorator(new PlainTextHolder("hello world"))
	);
	
        assertEquals(
	    "H-E-L-L-O-W-O-R-L-D",
	    holder.getText(),
	    "failed: UpperCaseDecorator(KebabDecorator(...))"
	);
    }
}

