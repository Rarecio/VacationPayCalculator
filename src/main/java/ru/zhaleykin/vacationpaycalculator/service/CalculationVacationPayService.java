package ru.zhaleykin.vacationpaycalculator.service;

import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDate;

@Validated
public interface CalculationVacationPayService {
    BigDecimal calculateVacationPay(
            @Min(value = 0, message = "средняя зарплата не должна быть меньше нуля") int avgSalary,
            @Min(value = 0, message = "количество дней отпуска не должно быть меньше нуля") int vacationDaysNumber);

    BigDecimal calculateVacationPay(
            @Min(value = 0, message = "средняя зарплата не должна быть меньше нуля") int avgSalary,
            @Min(value = 0, message = "количество дней отпуска не должно быть меньше нуля") int vacationDaysNumber,
            LocalDate vacationDate);
}
