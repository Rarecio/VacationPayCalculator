package ru.zhaleykin.vacationpaycalculator.service;

import org.springframework.stereotype.Service;
import ru.zhaleykin.vacationpaycalculator.entity.Holiday;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class CalculationVacationPayServiceImpl implements CalculationVacationPayService {
    public BigDecimal calculateVacationPay(int avgSalary, int vacationDaysNumber) {
        return BigDecimal.valueOf(avgSalary / 29.3)
                .setScale(2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(vacationDaysNumber));
    }

    @Override
    public BigDecimal calculateVacationPay(int avgSalary, int vacationDaysNumber, LocalDate vacationDate) {
        int counter = vacationDaysNumber;
        if(vacationDate != null) {
            for (int i = 0; i < vacationDaysNumber; i++) {
                if (Holiday.isHoliday(vacationDate) // в задании указано про выходные, но они учитываются как рабочие при рассчете отпускных
//                        || vacationDate.getDayOfWeek() == DayOfWeek.SATURDAY || vacationDate.getDayOfWeek() == DayOfWeek.SUNDAY
                )
                    counter--;
                vacationDate = vacationDate.plusDays(1);
            }
        }
        System.out.println(vacationDaysNumber);
        return calculateVacationPay(avgSalary, counter);
    }

}
