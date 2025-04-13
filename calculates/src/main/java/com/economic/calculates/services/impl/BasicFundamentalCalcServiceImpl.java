package com.economic.calculates.services.impl;

import com.economic.calculates.services.BasicFundamentalCalcService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class BasicFundamentalCalcServiceImpl implements BasicFundamentalCalcService {


    @Override
    public BigDecimal returnOnInvestment(BigDecimal valueOfInvestment, BigDecimal costOfInvestment) {
        var netInvestProfit = valueOfInvestment.subtract(costOfInvestment);


        return (netInvestProfit.divide(costOfInvestment, 4, RoundingMode.HALF_UP))
                .multiply(BigDecimal.valueOf(100));
    }

    @Override
    public BigDecimal calcFutureValueOfInvestment(BigDecimal presentValue, BigDecimal interestRate, int timeInYears) {
        // FV = PV * (1 + interestRate) ^ timeInYear;
        return presentValue.multiply((BigDecimal.valueOf(1).add(interestRate)).pow(timeInYears))
                .setScale(2, RoundingMode.DOWN);
    }
}
