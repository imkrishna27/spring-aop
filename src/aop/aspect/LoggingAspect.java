package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // declare point cut
    @Pointcut("execution(* aop.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* aop.dao.*.get*(..)))")
    public void getAllAopPackage() {}

    //combining pointcut
    @Pointcut("getAllAopPackage() && !getter()")
    public void excludeGetterAndGetAopPackage() {}

    // creating  aop advice for logging
    @Before("execution(public void addAccount())")
    public void logAnyInfo() {
        System.out.println("Before logging of any advice executed >> ");
    }

    @Before("excludeGetterAndGetAopPackage()")
    public void logMemberInfo() {
        System.out.println("Before logging of member advice executed >> ");
    }
}
