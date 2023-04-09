package aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberDao {
    public void addAccount() {
        System.out.println("In member Dao");
    }
}
