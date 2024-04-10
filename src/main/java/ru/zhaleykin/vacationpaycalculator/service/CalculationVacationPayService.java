package ru.zhaleykin.vacationpaycalculator.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CalculationVacationPayService {
    BigDecimal calculateVacationPay(int avgSalary, int vacationDaysNumber);

    BigDecimal calculateVacationPay(int avgSalary, int vacationDaysNumber,
            LocalDate vacationDate);
}
