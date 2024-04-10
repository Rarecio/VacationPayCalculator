package ru.zhaleykin.vacationpaycalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zhaleykin.vacationpaycalculator.service.CalculationVacationPayServiceImpl;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@Validated
public class VacationPayController {

    private final CalculationVacationPayServiceImpl calculationVacationPayService;

    @Autowired
    public VacationPayController(CalculationVacationPayServiceImpl calculationVacationPayService) {
        this.calculationVacationPayService = calculationVacationPayService;
    }

    @GetMapping("/calculacte")
    public ResponseEntity<BigDecimal> calculateVacationPay(
            @RequestParam
            @Min(value = 0, message = "средняя зарплата не должна быть отрицательной")
            int avgSalary,
            @RequestParam
            @Min(value = 0, message = "количество дней не должно быть отрицательным")
            int vacationDaysNumber,
            @RequestParam(required = false) LocalDate vacationDate) {
        return ResponseEntity.ok(calculationVacationPayService.calculateVacationPay(avgSalary, vacationDaysNumber, vacationDate));
    }
}
