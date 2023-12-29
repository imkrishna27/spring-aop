package aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // declare point cut
    @Pointcut("execution(* aop.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* aop.dao.*.dao*(..))")
    public void getAllAopPackage() {}

    //combining pointcut
    @Pointcut("getAllAopPackage() && !getter()")
    public void excludeGetterAndGetAopPackage() {}

    // creating  aop advice for logging
    @Before("execution(public void addAccount())")
    public void logAnyInfo() {
        System.out.println("Before logging of any advice executed >> ");
    }

    @After("execution(public void addAccount())")
    public void logAfterAnyInfo() {
        System.out.println("After logging of any advice executed >> ");
    }

    @AfterThrowing("execution(public void throwException())")
    public void logException() {
        System.out.println("some exception has been thrown");
    }

    @Before("excludeGetterAndGetAopPackage()")
    public void logMemberInfo() {
        System.out.println("Before logging of member advice executed >> ");
    }
}
