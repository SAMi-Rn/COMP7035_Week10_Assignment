package Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import Validation.InputValidation;

@Aspect
public class BasicAspect {

    @Before("execution(* *.*(..)) && args(arguments)")
    public void beforeMethodWithArguments(JoinPoint joinPoint, String[] arguments) {
        if (InputValidation.isValidArgumentCount(arguments)) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
    }
}



