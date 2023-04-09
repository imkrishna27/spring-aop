package aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
    public void addAccount() {
        System.out.println("In account Dao");
    }
}
