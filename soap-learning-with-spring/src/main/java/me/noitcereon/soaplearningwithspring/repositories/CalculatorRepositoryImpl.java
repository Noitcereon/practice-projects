package me.noitcereon.soaplearningwithspring.repositories;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculatorRepositoryImpl implements CalculatorRepository {

    @Override
    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }
}
