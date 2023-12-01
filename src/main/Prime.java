package main;

import java.util.ArrayList;
import java.util.List;

public class Prime {

    private List<Integer> primes;
    public int count = 0;
    public int sumOfPrimes = 0;

    public Prime(int firstNumber, int lastNumber) {
        if (firstNumber < 0 || firstNumber > lastNumber + 1) {
            throw new IllegalArgumentException("Invalid interval: firstNumber must be greater than or equal to 0, and firstNumber must be less than or equal to lastNumber");
        }

        primes = new ArrayList<>();
        calculatePrimes(firstNumber, lastNumber);
    }



    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void calculatePrimes(int current, int stop) {
        if (current > stop) {
            primes.add(0, count);
            primes.add(1, sumOfPrimes);
        } else if (isPrime(current)) {
            primes.add(current);
            ++count;
            sumOfPrimes += current;
            calculatePrimes(++current, stop);
        } else {
            calculatePrimes(++current, stop);
        }
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    public static void main(String[] args) {
        Prime prime = new Prime(1, 1000);
        System.out.println("Number of prime numbers: " + prime.count);
        System.out.println("Sum of prime numbers: " + prime.sumOfPrimes);
    }
}
