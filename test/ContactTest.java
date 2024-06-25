package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Contact;

public class ContactTest {

    @Test
    public void testContactIDEquals10() {
        assertDoesNotThrow(() -> new Contact("1234567890", "Elizabeth", "Smith", "9876543210", "456 Elm St."));
    }

    @Test
    public void testContactIDGreaterThan10() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Alex", "Johnson", "5555555555", "789 Oak St."));
    }

    @Test
    public void testContactIDIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Null", "Contact", "0000000000", "Null St."));
    }
    
    @Test
    public void testFirstNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456789", null, "Contact", "0000000000", "Null St."));
    }    
    
    @Test
    public void testFirstNameGreaterThan10() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456789", "Longerthan10", "Johnson", "5555555555", "789 Oak St."));
    }    
    
    @Test
    public void testLastNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456789", "Alex", null, "0000000000", "Null St."));
    }    
    
    @Test
    public void testLastNameGreaterThan10() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456789", "Alex", "Longerthan10", "5555555555", "789 Oak St."));
    }
    
    @Test
    public void testPhoneIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456789", "Alex", "Johnson", null, "Null St."));
    }  
    
    @Test
    public void testPhoneGreaterThan10() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456789", "Alex", "Johnson", "12345678901", "789 Oak St."));
    }
    
    @Test
    public void testPhoneLessThan10() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456789", "Alex", "Johnson", "123456789", "789 Oak St."));
    }
    
    @Test
    public void testPhoneEquals10() {
        assertDoesNotThrow(() -> new Contact("1234567890", "Elizabeth", "Smith", "9876543210", "456 Elm St."));
    }
    
    @Test
    public void testAddressIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456789", "Alex", "Johnson", "1234567890", null));
    }  
    
    @Test
    public void testAddressGreaterThan30() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456789", "Alex", "Johnson", "12345678901", "This is greater than 30 characters12345"));
    }
}