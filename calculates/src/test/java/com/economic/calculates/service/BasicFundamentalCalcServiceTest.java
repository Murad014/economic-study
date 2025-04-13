package com.economic.calculates.service;

import com.economic.calculates.services.impl.BasicFundamentalCalcServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasicFundamentalCalcServiceTest {
    @Autowired
    private BasicFundamentalCalcServiceImpl basicFundamentalCalcService;

    @Test
    @DisplayName("Return of Investment")
    public void givenValueOfInvestmentAndCostOfInvestment_whenCalcReturnOnInvestment_thenReturnBigDecimal() {
        // Arrange
        var valueOfInvestment = BigDecimal.valueOf(1_200); // Today worth of your invest
        var costOfInvestment = BigDecimal.valueOf(1_000);

        // Act
        var roi = basicFundamentalCalcService.returnOnInvestment(valueOfInvestment, costOfInvestment);

        // Assert
        assertNotNull(roi);
        assertEquals(new BigDecimal("20.0000"), roi);
    }

    @Test
    @DisplayName("Calc Future Value of Investment")
    public void givenPresentValueAndInterestRateAndTimeInYears_whenCalc_thenReturnFutureValueOfInvestment() {
        // Arrange
        var youInvestToday = BigDecimal.valueOf(1_000);
        var interestRate = BigDecimal.valueOf(0.08);
        var timeInYears = 3;

        // Act
        var fv = basicFundamentalCalcService.calcFutureValueOfInvestment(youInvestToday, interestRate, timeInYears);

        // Assert
        assertNotNull(fv);
        assertEquals(new BigDecimal("1259.71"), fv);
    }

}
