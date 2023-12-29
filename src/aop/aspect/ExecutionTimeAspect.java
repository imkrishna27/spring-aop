package aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    
    long startTime,endTime;
    @Before("@annotation(aop.annotations.MethodExecutionTime)")
    public void logAnyInfo() {
        System.out.println("method execution started: ");
        long startTime = System.currentTimeMillis();
    }

    @After("@annotation(aop.annotations.MethodExecutionTime)")
    public void logAfterAnyInfo() {
        endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("method execution ended: time taken is: "+ timeTaken);

    }
}
