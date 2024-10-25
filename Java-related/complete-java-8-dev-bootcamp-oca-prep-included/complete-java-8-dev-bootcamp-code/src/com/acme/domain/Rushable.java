package com.acme.domain;

import com.acme.utils.MyDate;

/**
 * Introduced in Lab 12 (Lambda Expressions)
 */
public interface Rushable {
    boolean isRushable(MyDate orderDate, double amount);
}
