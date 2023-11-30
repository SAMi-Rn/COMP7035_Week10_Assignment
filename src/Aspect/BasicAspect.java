package Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BasicAspect {
    @Before("   execution(void processInput(String)) ")
    public void beforeProcessInput(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("Before calling ProcessInput with arguement " + (String) args[0]);
    }


}