package test;

import main.Prime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {
    private Prime prime;

    @BeforeEach
    void setUp() {
        prime = new Prime(0, 1000);
    }

    @Test
    @DisplayName("Test for prime numbers calculation")
    void testCalculatePrimes() {
        List<Integer> primesList = prime.getPrimes();
        
        assertFalse(primesList.isEmpty(), "List of primes should not be empty");
        assertEquals(168, primesList.get(0), "Incorrect count of primes");
        assertEquals(76127, primesList.get(1), "Incorrect sum of primes");
        
        for (int i = 2; i < primesList.size(); i++) {
            assertTrue(prime.isPrime(primesList.get(i)), primesList.get(i) + " is a prime number");
        }
    }
    @Test
    @DisplayName("Test for input validation (Invalid Interval)")
    void testInputValidationInvalidInterval() {
        assertThrows(IllegalArgumentException.class, () -> new Prime(1000, 0),
                "IllegalArgumentException should be thrown for invalid interval");
    }

    @Test
    @DisplayName("Test for input validation (Valid Interval)")
    void testInputValidationValidInterval() {
        assertDoesNotThrow(() -> new Prime(0, 1000),
                "No exception should be thrown for valid interval");
    }
    
    @Test
    @DisplayName("Boundary Test: Negative First Number")
    void testInputValidationNegativeFirstNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Prime(-1, 1000),
                "IllegalArgumentException should have been thrown");
    }


    @Test
    @DisplayName("Boundary Test: Zero First Number")
    void testInputValidationZeroFirstNumber() {
        assertDoesNotThrow(() -> new Prime(0, 1),
                "No exception should be thrown for zero as the first number");
    }
    @Test
    @DisplayName("Boundary Test: Zero Last Number")
    void testInputValidationZeroLastNumber() {
        assertDoesNotThrow(() -> new Prime(1, 0),
                "No exception should be thrown for zero as the last number");
    }
}


