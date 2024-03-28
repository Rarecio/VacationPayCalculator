package ru.zhaleykin.vacationpaycalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zhaleykin.vacationpaycalculator.service.CalculationVacationPayServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class VacationPayController {

    private final CalculationVacationPayServiceImpl calculationVacationPayService;

    @Autowired
    public VacationPayController(CalculationVacationPayServiceImpl calculationVacationPayService) {
        this.calculationVacationPayService = calculationVacationPayService;
    }

    @GetMapping("/calculacte")
    public ResponseEntity<BigDecimal> calculateVacationPay(@RequestParam int avgSalary,
                                                           @RequestParam int vacationDaysNumber,
                                                           @RequestParam(required = false) LocalDate vacationDate){
        return ResponseEntity.ok(calculationVacationPayService.calculateVacationPay(avgSalary, vacationDaysNumber, vacationDate));
    }
}
