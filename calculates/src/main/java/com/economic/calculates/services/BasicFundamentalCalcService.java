package com.economic.calculates.services;

import java.math.BigDecimal;

public interface BasicFundamentalCalcService {
    /**
     * @return Return of Investment as percentage
     * @param valueOfInvestment value of your invest today
     * @param costOfInvestment your invest cost
     */
    BigDecimal returnOnInvestment(BigDecimal valueOfInvestment, BigDecimal costOfInvestment);

    /**
     * One dollar is worth more than a dollar in the future that is it.
     * @return Return Future value of Investment by parameters.
     * @param presentValue value of your invest today
     * @param interestRate interest rate. for example 0.08 = 8% as parameter you write 0.08
     * @param timeInYears what worth after time years?
     */
    BigDecimal calcFutureValueOfInvestment(BigDecimal presentValue, BigDecimal interestRate, int timeInYears);


}
