package ru.aston.homework.builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberCheckerTest {
    
    @Test
    public void shouldBuildUserProfileWithAllFields() {
	UserProfile profile = new UserProfile.Builder()
	    .username("Ivanov123")
	    .phoneNumber("+78005553535")
	    .age((short) 22)
	    .email("ivanov2004@example.ru")
	    .build();

	assertEquals("Ivanov123", profile.username());
	assertEquals("+78005553535", profile.phoneNumber());
	assertEquals(22, profile.age());
	assertEquals("ivanov2004@example.ru", profile.email());
    }
    
    @Test
    public void shouldApplyDefaultValuesWhenFieldsAreMissing() {
        UserProfile profile = new UserProfile.Builder()
                .username("123_example_123")
                .build();

        assertEquals("123_example_123", profile.username());
        assertNull(profile.phoneNumber());
        assertEquals(-1, profile.age());
        assertNull(profile.email());
    }
    
    @Test
    public void shouldFormatToStringCorrectlyWithValues() {
        UserProfile profile = new UserProfile.Builder()
                .username("YaPetya")
                .phoneNumber("+79271234512")
                .age((short) 40)
                .email("petya123@test.com")
                .build();

        String expected = "Profile:\n username -> YaPetya;\n age -> 40;\n email -> petya123@test.com;\n phoneNumber -> +79271234512";
        assertEquals(expected, profile.toString());
    }

    @Test
    public void shouldHandleUndefinedValuesInToString() {
        UserProfile profile = new UserProfile.Builder()
                .username("   ") 
                .build();

        String expected = "Profile:\n username -> undefined;\n age -> undefined;\n email -> undefined;\n phoneNumber -> undefined";
        assertEquals(expected, profile.toString());
    }
}


