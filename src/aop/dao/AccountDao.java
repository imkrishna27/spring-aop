package aop.dao;

import aop.annotations.MethodExecutionTime;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    @MethodExecutionTime
    public void addAccount() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("In account Dao");
    }

    public void throwException() {
        throw new ArithmeticException();
    }
}
