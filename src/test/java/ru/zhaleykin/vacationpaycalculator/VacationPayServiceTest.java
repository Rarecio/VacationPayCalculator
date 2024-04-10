package ru.zhaleykin.vacationpaycalculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.zhaleykin.vacationpaycalculator.service.CalculationVacationPayService;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VacationPayServiceTest {

    @Autowired
    CalculationVacationPayService calculationVacationPayService;

    @Test
    void calculateVacationPay(){
        BigDecimal vac = calculationVacationPayService.calculateVacationPay(1000, 8);
        assertEquals(vac, BigDecimal.valueOf(273.04));
    }

    @Test
    void calculateVacationPayWithDate(){
        BigDecimal vac =
                calculationVacationPayService.calculateVacationPay(1000, 8,
                        LocalDate.of(2024, 1, 9));
        assertEquals(vac, BigDecimal.valueOf(273.04));
    }

    @Test
    void calculateVacationPayOnHolidays(){
        BigDecimal vac =
                calculationVacationPayService.calculateVacationPay(1000, 10,
                        LocalDate.of(2024, 1, 1));
        assertEquals(vac, BigDecimal.valueOf(68.26));
    }
}
