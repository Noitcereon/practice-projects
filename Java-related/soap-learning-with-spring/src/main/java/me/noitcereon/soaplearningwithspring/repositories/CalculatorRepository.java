package me.noitcereon.soaplearningwithspring.repositories;

import java.math.BigDecimal;

public interface CalculatorRepository {
    BigDecimal add(BigDecimal a, BigDecimal b);
}
