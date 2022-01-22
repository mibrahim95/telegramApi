package com.mojo.telegramAPIValidator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
    public void test_isValidFullName_withValidName() {
        assertTrue(validator.isValidFullName("Mojahed Ibrahim"));
    }

    @Test
    public void test_isValidFullName_withInvalidName() {
        assertFalse(validator.isValidFullName("Mojahed Boobs"));
    }
}
