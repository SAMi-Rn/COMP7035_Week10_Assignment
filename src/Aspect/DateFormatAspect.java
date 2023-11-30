package Aspect;

import Validation.InputValidation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DateFormatAspect {

    @Before("execution(* *.*(..)) && args(startDate, endDate)")
    public void beforeDateValidation(JoinPoint joinPoint, String startDate, String endDate) {
        if (!InputValidation.isInteger(startDate) || !InputValidation.isInteger(endDate)) {
            throw new IllegalArgumentException("Date format is incorrect");
        }

        if (!InputValidation.checkInvalidDateValues(startDate, endDate)) {
            throw new IllegalArgumentException("Date values are invalid or out of range");
        }
    }
}
