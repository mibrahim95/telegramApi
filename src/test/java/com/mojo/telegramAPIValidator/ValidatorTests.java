package com.mojo.telegramAPIValidator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ValidatorTests {
    Validator validator = new Validator();

    @Test
    public void test_isValidEmail_withValidEmail() {
        assertTrue(validator.isValidEmail("username@domain.com"));
    }

    @Test
    public void test_isValidEmail_withInvalidEmail() {
        assertFalse(validator.isValidEmail("ddsfdfc"));
    }

    @Test
    public void test_isValidString_withValidStringAndLength() {
        assertTrue(validator.isValidString("Mojahed Ibrahim",5,100));
    }

    @Test
    public void test_isValidString_withValidStringAndInvalidMaxLength() {
        assertFalse(validator.isValidString("Hello World",0,10));
    }
    @Test
    public void test_isValidString_withValidStringAndInvalidMinLength() {
        assertFalse(validator.isValidString("Hello World",300,500));
    }

    @Test
    public void test_isValidString_withCurseWord() {
        assertFalse(validator.isValidString("Fuck the world",0,100));
    }

    @Test
    public void test_isValidString_withEmptyString() {
        assertTrue(validator.isValidString("",0,100));
    }
}
