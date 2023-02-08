package me.noitcereon.soaplearningwithspring.repositories;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorRepositoryImplTest {

    private final CalculatorRepository calculatorRepository = new CalculatorRepositoryImpl();
    @Test
    void givenTwoNumbers_WhenAdding_ThenReturnCombinedNumbers() {
        BigDecimal firstNumber = BigDecimal.valueOf(1.2);
        BigDecimal secondNumber = BigDecimal.valueOf(2.3);
        BigDecimal expected = BigDecimal.valueOf(3.5);

        BigDecimal actual = calculatorRepository.add(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }
}